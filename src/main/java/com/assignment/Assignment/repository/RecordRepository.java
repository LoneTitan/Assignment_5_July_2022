package com.assignment.Assignment.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.Assignment.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{

}

