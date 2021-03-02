package com.iraqsofit.speedoo.user;

import com.iraqsofit.speedoo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDateilsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        //return new User("admin",getPasswordEncoder().encode("admin"), AuthorityUtils.NO_AUTHORITIES);
        UserImp userImp =getUserByusername(user);
        if (userImp == null){
           throw  new NotFoundException("username or password not correct !");
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
        return userRepository.save(userImp);
    }

}
