package com.vachi.io.cardekho.repository;

import com.vachi.io.cardekho.entity.Cars;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarsRepo extends CrudRepository<Cars, Long> {

    @Query(value = "SELECT * FROM Cars where model = :model", nativeQuery = true)
    Optional<Object> findByModel(@Param("model") String model);

//    @Query(value = "SELECT * FROM Cars where price = :make",nativeQuery = true)
//    Optional<Object> findByPrice(@Param("make") int make);

    @Query(value = " update Cars c set c.price = :price WHERE c.id = :id", nativeQuery = true)
    Optional<Object> findByPrice(@Param("price") double price);

    @Query(value = "SELECT * FROM Cars where make = :make", nativeQuery = true)
    Optional<Object> getCarMake(@Param("make") String make);

    @Query(value = "SELECT * FROM Cars where panNo = :panNo", nativeQuery = true)
    Optional<Object> getCreditInfoById(@Param("panNo") String panNo);

    @Query(value = "SELECT * FROM Cars where model = :model", nativeQuery = true)
    Cars findByCarModel(@Param("model") String model);

    @Query(value = "SELECT * FROM Cars where vin = :vin", nativeQuery = true)
    List<Cars> getCarByVin(@Param("vin") Long vin);

    @Query(value = "SELECT * FROM Cars where year = :year",nativeQuery = true)
    List<Cars> getCarByYear(int year);

    @Query(value = "SELECT * FROM Cars where price = :price",nativeQuery = true)
    List<Cars> getCarByPrice(double price);
}

