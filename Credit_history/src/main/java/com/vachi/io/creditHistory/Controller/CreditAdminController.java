package com.vachi.io.creditHistory.Controller;

import com.vachi.io.creditHistory.Entity.CreditEntity;
import com.vachi.io.creditHistory.Repository.CreditRepository;
import com.vachi.io.creditHistory.Service.CreditService;
import com.vachi.io.creditHistory.config.CreditConfig;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Api(value = "Swagger2DemoRestController")
@RequestMapping("/admin")
@RestController
@Configuration
    public class CreditAdminController {

    @Autowired
    public CreditConfig creditConfig;

    @Autowired
    public CreditService creditService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public CreditRepository creditRepository;

    @PostMapping("/addCreditHistory")
    public CreditEntity addHistory(@RequestBody CreditEntity c1){
        return creditService.addHistory(c1);
    }

    @PutMapping("/updateCreditHistory/{id}")
    public ResponseEntity<CreditEntity> updateCreditHistory(@PathVariable(value = "id") Long id,
                                                            @RequestBody CreditEntity creditEntity){
        return creditService.updateCreditHistory(id,creditEntity);
    }

    @PutMapping("/updateCreditScore/{id}/{creditScore}")
    public ResponseEntity<CreditEntity> updateCreditScore(@PathVariable Long id, @PathVariable int creditScore){
        return creditService.updateCreditScore(id,creditScore);
    }
}