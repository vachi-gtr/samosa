package com.vachi.io.creditHistory.Controller;

import com.vachi.io.creditHistory.Entity.CreditEntity;
import com.vachi.io.creditHistory.Repository.CreditRepository;
import com.vachi.io.creditHistory.Service.CreditService;
import com.vachi.io.creditHistory.config.CreditConfig;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Api(value = "Swagger2DemoRestController")
@RequestMapping("/api")
@RestController
@Configuration
    public class CreditHistoryController {

    @Autowired
    public CreditService creditService;

    @Autowired
    public CreditConfig creditConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public CreditRepository creditRepository;

    @GetMapping("/getCreditHistory")
    public Iterable<CreditEntity> getCreditHistory(){
        return creditService.getCreditHistory();
    }

    @GetMapping("/getHistoryDetails")
    public List<Object> getHistoryDetails(){
        return creditService.getHistoryDetails();
    }

    @GetMapping("/findByCreditScore/{id}")
    public ResponseEntity<CreditEntity> getById(@PathVariable Long id) {
        return creditService.getById(id);
   }

    @GetMapping("/findByPanNo/{panNo}")
    public ResponseEntity<CreditEntity> getByPanNo(@PathVariable Long panNo){
        return creditService.getByPanNo(panNo);
    }

    @GetMapping("/findCreditHistoryByPanNo/{panNo}")
    public List<Object> getCreditHistoryByPan(@PathVariable Long panNo){
        return creditService.getCreditHistoryByPan(panNo);
    }

}