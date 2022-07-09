package com.assignment.Assignment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assignment.Assignment.exception.ResourceNotFoundException;
import com.assignment.Assignment.repository.RecordRepository;
import com.assignment.Assignment.model.Record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class RecordController {
    @Autowired
    private RecordRepository recordRepository;

    // get all employees
    @GetMapping("/records")
    public List<Record> getAllRecords(){
        return recordRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/records")
    public Record createEmployee(@RequestParam("provider") String provider, @RequestParam("provider") String flow, @RequestBody Record record) {
        record.setProvidername(provider);
        record.setFlowname(flow);
        return recordRepository.save(record);
    }

    // get employee by id rest api
    @GetMapping("/records/{id}")
    public ResponseEntity<Record> getEmployeeById(@PathVariable Long id) {
        Record record = recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not exist with id :" + id));
        return ResponseEntity.ok(record);
    }

    // update employee rest api
    @PutMapping("/records/{id}")
    public ResponseEntity<Record> updateEmployee(@PathVariable Long id, @RequestParam("provider") String provider, @RequestParam("provider") String flow,  @RequestBody Record recordDetails){
        Record record = recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not exist with id :" + id));

        record.setDowntime(recordDetails.getDowntime());
        record.setUptime(recordDetails.getUptime());
        record.setFlowname(flow);
        record.setProvidername(provider);

        Record updatedRecord = recordRepository.save(record);
        return ResponseEntity.ok(updatedRecord);
    }

    // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Record employee = recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not exist with id :" + id));

        recordRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

