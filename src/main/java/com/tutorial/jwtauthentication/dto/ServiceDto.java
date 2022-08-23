package com.tutorial.jwtauthentication.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ServiceDto {
    public ServiceDto() {
    }

    private long id;
    @NotEmpty
    private String merk;
    @NotEmpty
    private String motorcycle_type;
    @NotEmpty
    private String owner;
    @NotEmpty
    private String service_type;
    @NotEmpty
    private String complaint;
    @NotEmpty
    private String phone_number;
    @NotNull
    private int cost;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMotorcycle_type() {
        return motorcycle_type;
    }

    public void setMotorcycle_type(String motorcycle_type) {
        this.motorcycle_type = motorcycle_type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
