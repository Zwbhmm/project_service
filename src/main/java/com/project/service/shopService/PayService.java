package com.project.service.shopService;

import com.project.dao.shop.PayDao;
import com.project.model.shopEntity.Msoxq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayService {

    @Autowired
    private PayDao payDao;

    /**
     * 根据订单号查询mso中该订单是否已经支付
     *
     * @param msoid
     * @return
     */
    public String getPayState(String msoid){
        return payDao.getPayState(msoid);
    }

    /**
     * 根据订单号查询msoxq中的订单进行支付操作,返回集合
     *
     * @param msoid
     * @return
     */
    public List<Msoxq> payMoney(String msoid){
        return payDao.payMoney(msoid);
    }

}