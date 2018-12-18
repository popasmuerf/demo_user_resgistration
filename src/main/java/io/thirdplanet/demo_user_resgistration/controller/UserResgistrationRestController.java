package io.thirdplanet.demo_user_resgistration.controller;

import io.thirdplanet.demo_user_resgistration.Exception.CustomErrorType;
import io.thirdplanet.demo_user_resgistration.domain.User;
import io.thirdplanet.demo_user_resgistration.dto.UserDTO;
import io.thirdplanet.demo_user_resgistration.repos.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by mdb on 10/3/18.
 */
@RestController
//@RequestMapping("/api/user")
public class UserResgistrationRestController {

    public static final Logger logger = LoggerFactory.getLogger(UserResgistrationRestController.class);


    private UserJpaRepository userJpaRepository ;


    @Autowired
    public void setUserJpaRepository(UserJpaRepository userJpaRepository){
        this.userJpaRepository = userJpaRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> listAllUsers() {

        List<UserDTO> users = userJpaRepository.findAll();

        if(users != null && !users.isEmpty()){
            return new ResponseEntity <List<UserDTO>>(users,HttpStatus.OK);
        }else{
            return new ResponseEntity <List<UserDTO>>(users,HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById( @PathVariable("id")  Long id) {
        UserDTO user ;
        Optional<UserDTO> userOpt = userJpaRepository.findById(id);
        if(userOpt.isPresent()) {
            user = userOpt.get();
            return new ResponseEntity <UserDTO>(user,HttpStatus.OK);
        }else{
            user = new CustomErrorType("No user by id : " + id.toString() + " HTTP 404 ") ;
            return new ResponseEntity<UserDTO>(user,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody final UserDTO user){
        Long userId = user.getId() ;
        Optional<UserDTO> optUserDTO = userJpaRepository.findById(userId);
        if(optUserDTO.isPresent()){
            CustomErrorType errorUserDTO = new CustomErrorType("Cannot create this user...they might already exist...") ;
            return new ResponseEntity<UserDTO>(errorUserDTO,HttpStatus.CONFLICT);
        }else {
            userJpaRepository.save(user);
            return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
        }
    }


    @PutMapping(value="/{id}", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") final Long id,@RequestBody UserDTO user){
        Optional<UserDTO> optUserDTO = userJpaRepository.findById(id) ;
        UserDTO userDTO  = new UserDTO();
        if(optUserDTO.isPresent()){
            userDTO = optUserDTO.get() ;
            userDTO.setName(user.getName());
            userDTO.setAddress(user.getAddress());
            userDTO.setEmail(user.getEmail());
            userJpaRepository.saveAndFlush(userDTO);
        }else{
            CustomErrorType customErrorType = new CustomErrorType("unknown user....likely does not exist...");
            ResponseEntity<UserDTO> userDTOResponseEntity = new ResponseEntity<UserDTO>(customErrorType,HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") final Long id){
        Optional<UserDTO> userDTOOpt = userJpaRepository.findById(id);
        if(userDTOOpt.isPresent()){
            userJpaRepository.delete(userDTOOpt.get());
            return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
        }else{
            UserDTO  user = new CustomErrorType("No user by id : " + id.toString() + " HTTP 404 ") ;
            return new ResponseEntity<UserDTO>(user,HttpStatus.NOT_FOUND);
        }
    }



}
