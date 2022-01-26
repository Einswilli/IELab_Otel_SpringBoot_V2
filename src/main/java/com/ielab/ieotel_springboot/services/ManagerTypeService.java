package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.ManagerType;

import java.util.List;

public interface ManagerTypeService {

    public List<ManagerType> listManagerType();
    public ManagerType showManagerType(String id);
    public ManagerType showManagerTypeLib(String lib);
    public ManagerType saveManagerType(ManagerType managerType);
    public ManagerType updateManagerType(String id, ManagerType managerType) ;
    public void deleteManagerType(String id);
}
