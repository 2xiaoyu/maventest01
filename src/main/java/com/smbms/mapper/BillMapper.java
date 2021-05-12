package com.smbms.mapper;

import com.smbms.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    List<Bill> getAll(@Param("productName") String productName,
                      @Param("providerId") Integer providerId,
                      @Param("isPayment") Integer isPayment);
}
