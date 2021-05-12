package com.smbms.mapper;

import com.smbms.entity.Provider;

import java.util.List;

public interface ProviderMapper {
    int add(Provider provider);

    List<Provider> getall();

    Provider getById(int id);

}
