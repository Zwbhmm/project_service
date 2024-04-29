package com.project.model.shopEntity;

import lombok.Data;

/**
 * @Author
 * @Date
 * @DESCRIPTION: alipay接口参数
 * @Version V1.0
 */
@Data
public class AliPay {
    //订单编号
    private String traceNo;
    //商品金额
    private double totalAmount;
    //商品名称
    private String subject;
    //订单追踪号，商户自己生成，可已不使用
    private String alipayTraceNo;
}