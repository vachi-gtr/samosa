package com.vachi.io.carhistory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepo extends CrudRepository<Cars,Long> {

}
