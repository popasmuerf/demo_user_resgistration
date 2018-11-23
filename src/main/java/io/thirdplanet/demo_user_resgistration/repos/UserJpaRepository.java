package io.thirdplanet.demo_user_resgistration.repos;

import io.thirdplanet.demo_user_resgistration.domain.User;
import io.thirdplanet.demo_user_resgistration.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mdb on 10/3/18.
 */

@Repository
public interface UserJpaRepository extends JpaRepository<UserDTO,Long> {
    UserDTO findByName(String name );
}
