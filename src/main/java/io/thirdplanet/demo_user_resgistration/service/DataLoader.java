package io.thirdplanet.demo_user_resgistration.service;

import io.thirdplanet.demo_user_resgistration.domain.UserInfo;
import io.thirdplanet.demo_user_resgistration.dto.UserDTO;
import io.thirdplanet.demo_user_resgistration.repos.UserInfoJpaRepository;
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
   private UserInfoJpaRepository userInfoJpaRepository ;

    @Autowired
    public DataLoader(UserJpaRepository userJpaRepository, UserInfoJpaRepository userInfoJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.userInfoJpaRepository = userInfoJpaRepository ;
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


        UserInfo userInfo1 = new UserInfo() ;
        userInfo1.setUsername("admin");
        userInfo1.setPassword("{noop}admin");
        userInfo1.setRole("ADMIN");
        userInfo1.setEnabled(true);
        userInfoJpaRepository.save(userInfo1);

        /*
        UserInfo userInfo2 = new UserInfo() ;
        userInfo2.setUsername("admin");
        userInfo2.setPassword("{noop}admin");
        userInfo2.setRole("USER");
        userInfo2.setEnabled(true);
        userInfoJpaRepository.save(userInfo2);
        */
        
        UserInfo userInfo3 = new UserInfo() ;
        userInfo3.setUsername("foobar");
        userInfo3.setPassword("{noop}foobar");
        userInfo3.setRole("USER");
        userInfo3.setEnabled(true);
        userInfoJpaRepository.save(userInfo3);    
    
    }


}
