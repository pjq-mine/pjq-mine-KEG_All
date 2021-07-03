package com.ysu.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author keg
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeviceClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cId;

    private String cName;


}
