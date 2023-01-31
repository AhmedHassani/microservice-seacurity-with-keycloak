package com.iraqsofit.speedoo;

import com.iraqsofit.speedoo.service.UserDateilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class FirstRun implements CommandLineRunner {
    @Autowired
    private UserDateilsService service;
    @Override
    public void run(String... args) throws Exception {
        //UserImp userImp =new UserImp("ahmed11",service.getPasswordEncoder().encode("12345678"));
        //service.Save(userImp);
    }
}
