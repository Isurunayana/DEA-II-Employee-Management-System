package com.nsbm.ems.notificationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Sallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;
    private Double val;
    private String msg;
    private String empNic;
    private String timeStamp;
}
