package com.ysu.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "device")
@Entity
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long dId;
    @NotBlank(message = "设备名不能为空")
    private  String pName;
    private DeviceClass dClass;
    private String dBtime;
    private Integer dNumber;
    private  Double pPrice;
//    @NotBlank(message = "购买人不能为空")
    private  String userId;

    private DeviceManufacturer pManufacturer;
    private User user;
    private DeviceClass deviceClass;
    private DeviceManufacturer deviceManufacturer;
    private Integer dStatus;


}
