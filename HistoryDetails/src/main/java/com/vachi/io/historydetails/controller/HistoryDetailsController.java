package com.vachi.io.historydetails.controller;

import com.vachi.io.historydetails.Entity.HistoryEntity;
import com.vachi.io.historydetails.Reposotory.HistoryRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to History Entity!!!!")
@Configuration
@RequestMapping("/api")
public class HistoryDetailsController {

    @Autowired
    private HistoryRepository historyRepo;

    @GetMapping("/getHistory")
    public Iterable<HistoryEntity> getHistory(){
        return historyRepo.findAll();
    }

    @GetMapping("/getHistoryByPanNo/{panNo}")
    public ResponseEntity<Object> getHistoryByPanNo(@PathVariable(value = "panNo") Long panNo){
        Object historyEntity = historyRepo.findByPanNo(panNo);
        return ResponseEntity.ok().body(historyEntity);
    }

    @PostMapping("/addHistory")
    public HistoryEntity insertHistory(@RequestBody HistoryEntity entity){
        return historyRepo.save(entity);
   }

   @PutMapping("/updateHistoryDetails/{id}")
    public ResponseEntity<HistoryEntity> updateHistory(@PathVariable Long id, @RequestBody HistoryEntity entity) throws Exception {
       HistoryEntity history = historyRepo.findById(id)
               .orElseThrow(() -> new Exception("Not found for this id:" + id));

        history.setId(entity.getId());
       history.setPanNo(entity.getPanNo());
       history.setDetailsInfo(entity.getDetailsInfo());
       final HistoryEntity updatedentity = historyRepo.save(history);
       return ResponseEntity.ok(updatedentity);
   }
}
