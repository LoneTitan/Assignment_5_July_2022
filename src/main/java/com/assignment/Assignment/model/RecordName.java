package com.assignment.Assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "OperationSchedule")
public class RecordName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "providername")
    private String providername;

    @Column(name = "flowname")
    private String flowname;

    public RecordName(String providername, String flowname) {
        super();
        this.providername = providername;
        this.flowname = flowname;
    }



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getProvidername() {
        return providername;
    }
    public void setProvidername(String providername) {
        this.providername = providername;
    }

    public String getFlowname() {
        return flowname;
    }
    public void setFlowname(String flowname) {
        this.flowname = flowname;
    }



}
