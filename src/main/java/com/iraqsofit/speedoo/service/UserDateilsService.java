package com.iraqsofit.speedoo.service;

import com.iraqsofit.speedoo.models.OTP;
import com.iraqsofit.speedoo.models.Response;
import com.iraqsofit.speedoo.models.TokenResponse;
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

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class UserDateilsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Token token;


    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        //return new User("admin",getPasswordEncoder().encode("admin"), AuthorityUtils.NO_AUTHORITIES);
        UserImp userImp =getUserByusername(user);
        if (userImp == null){
           throw new Unauthorized("Unauthorized,invalid credentials (e.g., a bad password)");
        }
        return userImp;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public  UserImp getUserByusername(String user){
        return userRepository.findByUsername(user);
    }


    public UserImp Save(UserImp userImp){
        try {
            if(userRepository.existsByUsername(userImp.getUsername())){
                throw  new Unauthorized("phone number already in use");
            }else{
                return userRepository.save(userImp);
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found"));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        }catch (ConstraintViolationException e) {
            throw new BadRequest(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
        }
    }

   public Response setOtp(int otp, String username) {
       try {
           if(userRepository.existsByUsername(username)){
               UserImp userImp = userRepository.findByUsername(username);
               if(otp==123456) {
                   userImp.setIs_active(true);
                   userRepository.save(userImp);
                   return new Response(true, new ArrayList(), "success active account", 200);
               }
               return new Response(false, new ArrayList(), "error otp login failed", 401);

           }else{
               throw  new Unauthorized("phone number not used");
           }
       } catch (NoSuchElementException exception) {
           throw new NotFoundException(String.format("Not Found"));
       } catch (HttpClientErrorException.BadRequest exception) {
           throw new BadRequest("illegal request");
       }catch (ConstraintViolationException e) {
           throw new BadRequest(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
       }
    }

    public Response changePassword(String oldPassword,String newPassword,String username){
        try {
            if(userRepository.existsByUsername(username)){
                UserImp userImp = userRepository.findByUsername(username);
                if(BCrypt.checkpw(oldPassword,userImp.getPassword())) {
                    userImp.setPassword(newPassword);
                    String tokenSign = token.generateToken(userImp);
                    List<TokenResponse> tokens = new ArrayList<>();
                    tokens.add(new TokenResponse(tokenSign));
                    userRepository.save(userImp);
                    return new Response(true,tokens, "success change password account", 200);
                }else{
                    throw new BadRequest("failed old password and account password cannot be same");
                }
            }else{
                throw new BadRequest("Failed change password account");
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found"));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        }catch (ConstraintViolationException e) {
            throw new BadRequest(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
        }
    }

    public Response forgetPassword(String password,String username,String otp){
        try {
            if(userRepository.existsByUsername(username)){
                UserImp userImp = userRepository.findByUsername(username);
                if(otp.equals("123456")) {
                    userImp.setPassword(password);
                    String tokenSign = token.generateToken(userImp);
                    List<TokenResponse> tokens = new ArrayList<>();
                    tokens.add(new TokenResponse(tokenSign));
                    userRepository.save(userImp);
                    return new Response(true,tokens, "success change password account", 200);
                }else{
                    throw new BadRequest("failed otp code not correct !!");
                }
            }else{
                throw new BadRequest("Failed change password account");
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found"));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        }catch (ConstraintViolationException e) {
            throw new BadRequest(e.getConstraintViolations().stream().findFirst().get().getMessageTemplate());
        }
    }

    public Response sendOTPForgetPassword(String username){
        if(userRepository.existsByUsername(username)) {
            UserImp userImp = userRepository.findByUsername(username);
            ArrayList  list  =new ArrayList();
            list.add(new OTP(123456,username));
            return new Response(true,list, "success change password account", 200);
        }else {
            return new Response(true,new ArrayList(), "success change password account", 400);
        }

    }






}
