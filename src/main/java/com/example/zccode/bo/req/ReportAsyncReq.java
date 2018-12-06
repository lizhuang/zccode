package com.example.zccode.bo.req;

import lombok.Data;

@Data
public class ReportAsyncReq extends BaseRequest {
    /**
     * 公司id
     */
    private int companyId;

    /**
     * 文件路径
     */
    private String filePath;
}
