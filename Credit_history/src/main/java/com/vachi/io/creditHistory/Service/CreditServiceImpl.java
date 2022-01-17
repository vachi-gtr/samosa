package com.vachi.io.creditHistory.Service;

import com.vachi.io.creditHistory.Entity.CreditEntity;
import com.vachi.io.creditHistory.Repository.CreditRepository;
import com.vachi.io.creditHistory.config.CreditConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CreditServiceImpl implements CreditService{

    @Autowired
    CreditConfig creditConfig;

    @Autowired
    CreditRepository creditRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Iterable<CreditEntity> getCreditHistory(){
        return creditRepository.findAll();
    }

    @Override
    public List<Object> getHistoryDetails(){
        Object[] carHistory = restTemplate.getForObject(creditConfig.getCreditUrl(),Object[].class);
        return Arrays.asList(carHistory);
    }

    @Override
    public List<Object> getCreditHistoryByPan(Long panNo) {
        Object[] carHistory = restTemplate.getForObject(creditConfig.getHistoryUrl() + "/" + panNo,Object[].class);
        return  Arrays.asList(carHistory);
    }

    @Override
    public ResponseEntity<CreditEntity> getById(@PathVariable Long id) {
        Optional<CreditEntity> user = creditRepository.findById(id);
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreditEntity> getByPanNo(@PathVariable Long panNo){
        CreditEntity credit = creditRepository.findByPanNo(panNo);
        return ResponseEntity.ok().body(credit);
    }

    @Override
    public CreditEntity addHistory(@RequestBody CreditEntity c1){
        return creditRepository.save(c1);
    }


    @Override
    public ResponseEntity<CreditEntity> updateCreditHistory(@PathVariable(value = "id") Long id,
                                                            @RequestBody CreditEntity creditEntity){
        CreditEntity credit = creditRepository.findById(id).orElseThrow();
        credit.setCreditScore(creditEntity.getCreditScore());
        credit.setAddress(creditEntity.getAddress());
        credit.setPanNo(creditEntity.getPanNo());
        credit.setLastName(creditEntity.getLastName());
        credit.setFirstName(creditEntity.getFirstName());
        final CreditEntity updatedEmployee = creditRepository.save(credit);
        return ResponseEntity.ok(updatedEmployee);
    }

    @Override
    public ResponseEntity<CreditEntity> updateCreditScore(@PathVariable Long id, @PathVariable int creditScore){
        try {
            CreditEntity customer = creditRepository.findById(id).get();
            customer.setCreditScore(creditScore);
            return new ResponseEntity<CreditEntity>(creditRepository.save(customer), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
