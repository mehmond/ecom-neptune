package com.app.NeptuneDemo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private long eventId;
    @Column(name = "event_name", nullable = false)
    private String eventName;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Coupon> coupons;
    
    public Event() {

    }

    public Event(Long eventId, String eventName, Date startDate, Date endDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
