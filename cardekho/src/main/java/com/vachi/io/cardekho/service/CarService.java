package com.vachi.io.cardekho.service;

import com.vachi.io.cardekho.Exception.ResourceNotFoundException;
import com.vachi.io.cardekho.entity.Cars;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarService {

    public Iterable<Cars> getCarDetails();

    public List<Cars> getCarByYear(int year);

    public List<Cars> getCarByPrice( double price);

    public List<Cars> getCarByVin(long vin );

    public List<Object> getCreditInfo();


    List<Object> getCreditInfo(Long panNo);

    public Optional<Object> getCarMake(String make);

    public ResponseEntity<Object> getCarsByModel( String model)
            throws ResourceNotFoundException;

    public Cars insertNewCars( Cars c1);

    public ResponseEntity<Cars> updateExistingCarPrice(  Long id,
                                                         Cars carDetails) throws ResourceNotFoundException;

    public ResponseEntity<Cars> updateCars( Long id,
                                            Cars carDetails) throws ResourceNotFoundException;

    public Map<String, Boolean> deleteCar(Long id) throws ResourceNotFoundException;

    public List<Object> getHistoryDetails();

    public List<Object> getHistoryByPan(Long panNo);

    public List<Object> getCreditByPanNo(Long panNo);
}
