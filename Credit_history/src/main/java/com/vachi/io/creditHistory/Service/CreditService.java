package com.vachi.io.creditHistory.Service;


import com.vachi.io.creditHistory.Entity.CreditEntity;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface CreditService {

    public CreditEntity addHistory(CreditEntity c1);

    public Iterable<CreditEntity> getCreditHistory();

    public List<Object> getHistoryDetails();


    public ResponseEntity<CreditEntity> getById(Long id);

    public ResponseEntity<CreditEntity> getByPanNo(Long panNo);

    public ResponseEntity<CreditEntity> updateCreditHistory(Long id,CreditEntity creditEntity);

    public ResponseEntity<CreditEntity> updateCreditScore(Long id,int creditScore);


    public List<Object> getCreditHistoryByPan(Long panNo);
}
