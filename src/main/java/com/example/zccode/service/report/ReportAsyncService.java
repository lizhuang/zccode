package com.example.zccode.service.report;

import com.example.zccode.bo.req.ReportAsyncReq;
import com.example.zccode.bo.result.ReportAsyncResult;
import com.example.zccode.bo.result.ReportAsyncTicketResult;

/**
 * 异步查询接口
 *
 */
public interface ReportAsyncService {

    /**
     * 申请报表查询
     * @param req
     * @return
     */
    public ReportAsyncTicketResult applyReport(ReportAsyncReq req);

    /**
     * 查询早请后的报表，如果没有完成将返回一个数字表示进度
     * 查询时需要传递申请时给出的ID
     * 如果报表已经生成，将返回生成好的报表
     * @param req
     * @return
     */
    public ReportAsyncResult queryReport(ReportAsyncReq req);

}
