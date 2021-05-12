package com.smbms.service;

import com.smbms.entity.Provider;

import java.sql.SQLException;
import java.util.List;

public interface ProviderService {
    int add(Provider provider) throws SQLException;

    List<Provider> getall();

    Provider getById(int id);
}
