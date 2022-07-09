
package com.assignment.Assignment.controller;

import com.assignment.Assignment.exception.ResourceNotFoundException;
import com.assignment.Assignment.model.Record;
import com.assignment.Assignment.repository.RecordRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@RestController
@RequestMapping({"/api/v1/"})
public class RecordController {
    @Autowired
    private RecordRepository recordRepository;

    public RecordController() {
    }

    @GetMapping({"/records"})
    public List<Record> getAllRecords() {
        return this.recordRepository.findAll();
    }

    @PostMapping({"/records"})
    public Record createEmployee(@RequestBody Record record) {
        return (Record)this.recordRepository.save(record);
    }

    @GetMapping({"/records/{id}"})
    public ResponseEntity<Record> getEmployeeById(@PathVariable Long id) {
        Record record = (Record)this.recordRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Record not exist with id :" + id);
        });
        return ResponseEntity.ok(record);
    }

    @PutMapping({"/records/{id}"})
    public ResponseEntity<Record> updateEmployee(@PathVariable Long id, @RequestBody Record recordDetails) {
        Record record = (Record)this.recordRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Record not exist with id :" + id);
        });
        record.setDowntime(recordDetails.getDowntime());
        record.setUptime(recordDetails.getUptime());
        record.setFlowname(recordDetails.getFlowname());
        record.setProvidername(record.getProvidername());
        Record updatedRecord = (Record)this.recordRepository.save(record);
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping({"/records/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Record employee = (Record)this.recordRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Record not exist with id :" + id);
        });
        this.recordRepository.delete(employee);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}