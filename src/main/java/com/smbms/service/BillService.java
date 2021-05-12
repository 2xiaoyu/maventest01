package com.smbms.service;

import com.smbms.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillService {
    List<Bill> getall(@Param("productName") String productName,
                      @Param("providerId") Integer providerId,
                      @Param("isPayment") Integer isPayment);
}
