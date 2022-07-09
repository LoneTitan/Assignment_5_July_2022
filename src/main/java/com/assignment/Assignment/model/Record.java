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
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "uptime")
    private LocalDateTime uptime;

    @Column(name = "downtime")
    private LocalDateTime downtime;

    @Column(name = "providername")
    private String providername;

    @Column(name = "flowname")
    private String flowname;

    public Record() {

    }

    public Record(LocalDateTime uptime, LocalDateTime downtime, String providername, String flowname) {
        super();

        this.uptime = uptime;
        this.downtime = downtime;
        this.providername = providername;
        this.flowname = flowname;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getUptime() {
        return uptime;
    }
    public void setUptime(LocalDateTime uptime) {
        this.uptime = uptime;
    }

    public LocalDateTime getDowntime() {
        return downtime;
    }
    public void setDowntime(LocalDateTime downtime) {
        this.downtime = downtime;
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
