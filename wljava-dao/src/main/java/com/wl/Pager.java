package com.wl;

import lombok.Data;

@Data
public class Pager {
    private int pageSize;
    private int pageNum;
    private int totalCount;
    private int totalPage;
}
