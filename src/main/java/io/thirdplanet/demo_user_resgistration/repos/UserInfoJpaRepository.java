package io.thirdplanet.demo_user_resgistration.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.thirdplanet.demo_user_resgistration.domain.UserInfo;

@Repository
public interface UserInfoJpaRepository extends JpaRepository<UserInfo,Long>{
    public UserInfo findByUsername(String username);
}