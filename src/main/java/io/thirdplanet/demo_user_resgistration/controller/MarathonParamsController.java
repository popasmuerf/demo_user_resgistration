package io.thirdplanet.demo_user_resgistration.controller;




import io.thirdplanet.demo_user_resgistration.dto.MarathonParamsDTO;

import io.thirdplanet.demo_user_resgistration.repos.MarathonParamsRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;









@RestController
public class MarathonParamsController {

    public static final Logger logger = LoggerFactory.getLogger(UserResgistrationRestController.class);

    private MarathonParamsRespository marathonParamsRespository ;


    private static int count = 0 ;
    @Autowired
    public void setMarathonParamsRespository(MarathonParamsRespository marathonParamsRespository){
        this.marathonParamsRespository = marathonParamsRespository;
    }

    public static List<MarathonParamsDTO> paramsList = new ArrayList<>();
    //private MarathonInputJpaRepository marathonInputJpaRepository ;

    /*
        COMPANY_NAME
        OBSERVED_SYSTEM_NAME
        OBSERVED_SYSTEM_API
        OBSERVED_SYSTEM_SECRET

     */





    @GetMapping("/marathon_inputs/")
    public List<MarathonParamsDTO> getInputs(){
        // MarathonParamsDTO params = marathonInputsRepository.findByFromAndTo(from, to);
        // exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        MarathonParamsDTO marathonParamsDTO  = new MarathonParamsDTO();
        marathonParamsDTO.setId((long) count); count ++ ;
        marathonParamsDTO.setCOMPANY_NAME("Third Planet IO");
        marathonParamsDTO.setOBSERVED_SYSTEM_NAME("BLUE SYSTEM");
        marathonParamsDTO.setOBSERVED_SYSTEM_API("BLUE SYSTEM API");
        marathonParamsDTO.setOBSERVED_SYSTEM_SECRET("secret system 8");

        paramsList.add(marathonParamsDTO);
        //return marathonParamsDTO ;
        return paramsList ;
    }



    @PostMapping("/marathon_inputs/{COMPANY_NAME}/{OBSERVED_SYSTEM_NAME}/{OBSERVED_SYSTEM_API}/{OBSERVED_SYSTEM_SECRET}")
    public MarathonParamsDTO retrieveExchangeValue(@PathVariable String COMPANY_NAME,
                                                   @PathVariable String OBSERVED_SYSTEM_NAME,
                                                   @PathVariable String OBSERVED_SYSTEM_API,
                                                   @PathVariable String OBSERVED_SYSTEM_SECRET){
       // MarathonParamsDTO params = marathonInputsRepository.findByFromAndTo(from, to);
       // exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

         MarathonParamsDTO marathonParamsDTO  = new MarathonParamsDTO();
         marathonParamsDTO.setCOMPANY_NAME("Third Planet IO");
         marathonParamsDTO.setOBSERVED_SYSTEM_NAME("BLUE SYSTEM");
         marathonParamsDTO.setOBSERVED_SYSTEM_API("BLUE SYSTEM API");
         marathonParamsDTO.setOBSERVED_SYSTEM_SECRET("secret system 8");
        return new MarathonParamsDTO() ;
    }


}//endclass
