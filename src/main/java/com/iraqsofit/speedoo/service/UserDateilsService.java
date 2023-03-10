package com.iraqsofit.speedoo.service;

import com.iraqsofit.speedoo.models.*;
import com.iraqsofit.speedoo.security.Token;
import com.iraqsofit.speedoo.user.UserImp;
import com.iraqsofit.speedoo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.iraqsofit.speedoo.exception.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserDateilsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Token token;
    @Autowired
    private TwilioOTP twilioOTP;
    @Autowired
    private AddressServer addressServer;


    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        //return new User("admin",getPasswordEncoder().encode("admin"), AuthorityUtils.NO_AUTHORITIES);
        UserImp userImp = getUserByusername(user);
        if (userImp == null) {
            throw new Unauthorized("Unauthorized,invalid credentials (e.g., a bad password)");
        }
        return userImp;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UserImp getUserByusername(String user) {
        return userRepository.findByUsername(user);
    }


    public UserImp Save(UserImp userImp) {
        try {
            if (userRepository.existsByUsername(userImp.getUsername())) {
                throw new Unauthorized("phone number already in use");
            } else {
                //long userId, String location, String city, String address
                UserImp newUser = userRepository.save(userImp);
                addressServer.save(new AddressInfo(newUser.getUsername(),newUser.getLocation(),newUser.getCity(),newUser.getAddress(),"الاساسي"));
                return newUser;
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found"));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        } catch (ConstraintViolationException e) {
            throw new BadRequest(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
        }
    }

    public Response setOtp(int otp, String username) {
        try {
            if (userRepository.existsByUsername(username)) {
                UserImp userImp = userRepository.findByUsername(username);
                String otpHash[] = userImp.getOtp().split(",");
                if (checkOTP(otpHash,otp)) {
                    userImp.setIs_active(true);
                    userRepository.save(userImp);
                    return new Response(true, new ArrayList(), "success active account", 200);
                }
                return new Response(false, new ArrayList(), "error otp login failed", 401);

            } else {
                throw new Unauthorized("phone number not used");
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found"));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        } catch (ConstraintViolationException e) {
            throw new BadRequest(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
        }
    }

    private boolean checkOTP(String[] otpHash, int otp) {
        String code = otpHash[0];
        String date = otpHash[1];
        Date date1 = new Date();
        Date date2 = new Date(Long.parseLong(date) + 920000);
        System.out.println("checkOTP : code  "+ code);
        System.out.println("checkOTP : otp  "+ otp);
        if (date1.getTime() < date2.getTime()) {
            if (code.equals(otp+"".trim())) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public Response changePassword(String oldPassword, String newPassword, String username) {
        try {
            if (userRepository.existsByUsername(username)) {
                UserImp userImp = userRepository.findByUsername(username);
                if (BCrypt.checkpw(oldPassword, userImp.getPassword())) {
                    userImp.setPassword(getPasswordEncoder().encode(newPassword));
                    String tokenSign = token.generateToken(userImp);
                    List<TokenResponse> tokens = new ArrayList<>();
                    tokens.add(new TokenResponse(tokenSign));
                    userRepository.save(userImp);
                    return new Response(true, tokens, "success change password account", 200);
                } else {
                    throw new BadRequest("failed old password and account password cannot be same");
                }
            } else {
                throw new BadRequest("Failed change password account");
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found"));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        } catch (ConstraintViolationException e) {
            throw new BadRequest(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
        }
    }


    public Response forgetPassword(String password, String username, String otp) {
        try {
            if (userRepository.existsByUsername(username)) {
                UserImp userImp = userRepository.findByUsername(username);
                if (checkOTP(userImp.getOtp().split(","),Integer.parseInt(otp))) {
                    userImp.setPassword(getPasswordEncoder().encode(password));
                    String tokenSign = token.generateToken(userImp);
                    List<TokenResponse> tokens = new ArrayList<>();
                    tokens.add(new TokenResponse(tokenSign));
                    userRepository.save(userImp);
                    return new Response(true, tokens, "success change password account", 200);
                } else {
                    throw new BadRequest("failed otp code not correct !!");
                }
            } else {
                throw new BadRequest("Failed change password account");
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found"));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        } catch (ConstraintViolationException e) {
            throw new BadRequest(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
        }
    }

    public Response sendOTPForgetPassword(String username) {
        if (userRepository.existsByUsername(username)) {
            UserImp userImp = userRepository.findByUsername(username);
            String otpDb =twilioOTP.sms(username);
            String [] otps = otpDb.split(",");
            userImp.setOtp(otpDb);
            userRepository.save(userImp);
            ArrayList list = new ArrayList();
            list.add(new OTP(Integer.parseInt(otps[0]), username));
            return new Response(true, list, "success", 200);
        } else {
            return new Response(true, new ArrayList(), "something wrong", 400);
        }
    }


    public Response getNotificationById(String username) {
        if (userRepository.existsByUsername(username)) {
            UserImp userImp = userRepository.findByUsername(username);
            return new Response(true, userImp.getNotification(), "success", 200);
        } else {
            return new Response(true, new ArrayList(), "empty notification", 400);
        }
    }


    public Response pushNotificationById(String username, NotificationModel notificationModel) {
        if (userRepository.existsByUsername(username)) {
            UserImp userImp = userRepository.findByUsername(username);
            List<NotificationModel> notificationModelList = new ArrayList<>();
            notificationModelList.add(notificationModel);
            userImp.setNotification(notificationModelList);
            return new Response(true, notificationModelList, "success", 200);
        } else {
            return new Response(true, new ArrayList(), "empty notification", 400);
        }
    }

    public Response updateUser(String username, UserUpdateModel user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return new Response(true, new ArrayList(), "number phone alerdy used", 400);
        } else {
            UserImp userDetails1 = userRepository.findByUsername(user.getUsername());
            userDetails1.setName(user.getName());
            userDetails1.setUsername(user.getUsername());
            userDetails1.setAddress(user.getAddress());
            List<UserImp> userImpList = new ArrayList<>();
            userImpList.add(userDetails1);
            return new Response(true, userImpList, "success", 200);
        }
    }



    public boolean deleteByUsername(String username) {
        userRepository.delete(userRepository.findByUsername(username));
        return true;
    }
}
