package io.thirdplanet.demo_user_resgistration.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.thirdplanet.demo_user_resgistration.domain.UserInfo;
import io.thirdplanet.demo_user_resgistration.repos.UserInfoJpaRepository;

@Service
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoJpaRepository userInfoJpaRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserInfo userInfo = userInfoJpaRepository.findByUsername(username);
        if(userInfo == null){
            throw new UsernameNotFoundException("Blaaargg!!!! user not foun with user-name: " + username);   
        }

        return new org.springframework.security.core.userdetails.User(userInfo.getUsername(),
                                                                      userInfo.getPassword(),
                                                                      getAuthorities(userInfo));   
    }
    

    private Collection<GrantedAuthority> getAuthorities(UserInfo userInfo){
        List<GrantedAuthority> authorities = new ArrayList<>() ;
        authorities = AuthorityUtils.createAuthorityList(userInfo.getRole());
        return authorities ;
    }
    
}