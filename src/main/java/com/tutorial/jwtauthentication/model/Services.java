package com.tutorial.jwtauthentication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "motorcycle_type")
    private String motorCycleType;

    @Column(name = "owner")
    private String owner;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "cost")
    private int cost;

    @Column(name = "status", columnDefinition="varchar(255) default 'WAITING'")
    private String status;
}
