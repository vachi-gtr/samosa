package com.vachi.io.creditHistory.Repository;

import com.vachi.io.creditHistory.Entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CreditRepository extends JpaRepository<CreditEntity,Long> {

//    @Query(value = "SELECT * FROM CreditEntity WHERE panNo = :panNo",nativeQuery = true)
    CreditEntity findByPanNo(@Param("panNo") Long panNo);

//    @Query(value = " update CreditEntity c set c.creditScore = :price WHERE c.id = :id", nativeQuery = true)
//    List<CreditEntity> findByPrice(@Param("creditScore") double price);

}
