package com.proxym.fraudDetection.entities;

import jakarta.persistence.*;

@Entity
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;
    private Boolean approval;
    @OneToOne
    private User user;

    public ServiceRequest() {
    }

    public ServiceRequest(int requestId, Boolean approval, User user) {
        this.requestId = requestId;
        this.approval = approval;
        this.user = user;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Boolean getApproval() {
        return approval;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
