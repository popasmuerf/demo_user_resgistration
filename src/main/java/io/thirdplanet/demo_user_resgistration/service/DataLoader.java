package io.thirdplanet.demo_user_resgistration.service;

import io.thirdplanet.demo_user_resgistration.dto.UserDTO;
import io.thirdplanet.demo_user_resgistration.repos.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by mdb on 10/7/18.
 */
@Service
public class DataLoader {

   private  UserJpaRepository userJpaRepository;

    @Autowired
    public DataLoader(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @PostConstruct
    private void initDataBase(){
        UserDTO userDTO1 = new UserDTO() ;
        userDTO1.setName("mikeyb");
        userDTO1.setAddress("12120 Flag Harbor Driver Germantown MD 20874");
        userDTO1.setEmail("MichaelBrown172@Gmail.com");
        userJpaRepository.save(userDTO1);

        UserDTO userDTO2 = new UserDTO() ;
        userDTO2.setName("CharlieQ");
        userDTO2.setAddress("12121 Flag Harbor Driver Germantown MD 20874");
        userDTO2.setEmail("CharlieQ@Gmail.com");
        userJpaRepository.save(userDTO2);

        UserDTO userDTO3 = new UserDTO() ;
        userDTO3.setName("Cenk Uyger");
        userDTO3.setAddress("1111 Red st Colortown MD 20874");
        userDTO3.setEmail("cenkuyger@Gmail.com");
        userJpaRepository.save(userDTO3);


    }


}
