package com.smbms.service;

import com.smbms.entity.Provider;
import com.smbms.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    ProviderMapper providerMapper;

    @Override
    public int add(Provider provider) throws SQLException {
        return providerMapper.add(provider);
    }

    @Override
    public List<Provider> getall() {
        return providerMapper.getall();
    }

    @Override
    public Provider getById(int id) {
        return providerMapper.getById(id);
    }
}
