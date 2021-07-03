package com.ysu.entity.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QueryVo {
    private Integer curr;
    private Integer limit;
    private String keyword;
    private Integer status;
    private Long group_select;
    private Long research_select;
}
