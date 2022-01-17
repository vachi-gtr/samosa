package com.vachi.io.historydetails.Reposotory;

import com.vachi.io.historydetails.Entity.HistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface HistoryRepository extends CrudRepository<HistoryEntity, Long> {

    List<HistoryEntity> findByPanNo(@Param("panNo") Long panNo);

}

