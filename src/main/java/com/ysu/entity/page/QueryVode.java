package com.ysu.entity.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QueryVode {
    private Integer curr;
    private Integer limit;
    private String keyword;
    private Integer status;
    private Long dClass_select;
    private Long pManufacturer_select;
}
