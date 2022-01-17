package com.vachi.io.cardekho.service;

import com.vachi.io.cardekho.Exception.ResourceNotFoundException;
import com.vachi.io.cardekho.config.CarConfig;
import com.vachi.io.cardekho.entity.Cars;
import com.vachi.io.cardekho.repository.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CarserviceImpl implements CarService{

    @Autowired
    public CarConfig carConfig;

    @Autowired
    private CarsRepo carsRepo;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Iterable<Cars> getCarDetails() {
        return carsRepo.findAll();
    }

    @Override
    public List<Cars> getCarByYear(int year){
        return carsRepo.getCarByYear(year);
    }

    @Override
    public List<Cars> getCarByPrice( double price){
        return carsRepo.getCarByPrice(price);
    }

    @Override
    public List<Cars> getCarByVin( long vin ){
        return carsRepo.getCarByVin(vin);
    }

    @Override
    public List<Object> getCreditInfo() {
        Object[] carHistory = restTemplate.getForObject(carConfig.getCreditUrl(),Object[].class);
        return Arrays.asList(carHistory);
    }

    @Override
    public List<Object> getHistoryDetails() {
        Object[] carHistory = restTemplate.getForObject(carConfig.getHistoryDetailsUrl(),Object[].class);
        return Arrays.asList(carHistory);
    }

    @Override
    public List<Object> getHistoryByPan(Long panNo){
        Object[] carHistory = restTemplate.getForObject(carConfig.getHistoryByPanUrl() + "/" + panNo,Object[].class);
        return Arrays.asList(carHistory);
    }

    @Override
    public List<Object> getCreditByPanNo(Long panNo){
        Object[] carHistory = restTemplate.getForObject(carConfig.getCreditByPanUrl() + "/" + panNo,Object[].class);
        return Arrays.asList(carHistory);
    }

    @Override
    public List<Object> getCreditInfo(Long panNo) {
        Object[] carHistory = restTemplate.getForObject(carConfig.getCreditUrl()+ "/" + panNo,Object[].class);
        return Arrays.asList(carHistory);
    }

    @Override
    public Optional<Object> getCarMake(String make) {
        return carsRepo.getCarMake(make);
    }

    @Override
    public ResponseEntity<Object> getCarsByModel(String model)
            throws ResourceNotFoundException {
        Object cars = carsRepo.findByModel(model)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for this id ::" + model));
        return ResponseEntity.ok().body(cars);
    }


    @Override
    public Cars insertNewCars( Cars c1) {
        return carsRepo.save(c1);
    }

    @Override
    public ResponseEntity<Cars> updateExistingCarPrice(Long id,
                                                         Cars carDetails) throws ResourceNotFoundException {
        Cars cars = carsRepo.findByCarModel(carDetails.getModel());
        cars.setPrice(carDetails.getPrice());
        final Cars updateExistingCarPrice = carsRepo.save(cars);
         return ResponseEntity.ok(updateExistingCarPrice);
    }

    @Override
    public ResponseEntity<Cars> updateCars( Long id,
                                            Cars carDetails) throws ResourceNotFoundException {
        Cars cars = carsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + id));

        cars.setVin(carDetails.getVin());
        cars.setMake(carDetails.getMake());
        cars.setModel(carDetails.getModel());
        cars.setYear(carDetails.getYear());
        cars.setPrice(carDetails.getPrice());
        final Cars updatedCars = carsRepo.save(cars);
        return ResponseEntity.ok(updatedCars);
    }

    @Override
    public Map<String, Boolean> deleteCar(Long id) throws ResourceNotFoundException {
        Cars cars = carsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found for this id::" + id));
        this.carsRepo.delete(cars);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
