package com.smbms.service;

import com.smbms.entity.Bill;
import com.smbms.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;

    @Override
    public List<Bill> getall(String productName, Integer providerId, Integer isPayment) {
        return billMapper.getAll(productName, providerId, isPayment);
    }
}
