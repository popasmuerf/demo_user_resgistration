package io.thirdplanet.demo_user_resgistration.repos;

import io.thirdplanet.demo_user_resgistration.domain.MarathonParams;
import io.thirdplanet.demo_user_resgistration.dto.MarathonParamsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarathonParamsRespository extends JpaRepository<MarathonParamsDTO,Long> {

    default Long  findById() {
        return findById();
    }
}
