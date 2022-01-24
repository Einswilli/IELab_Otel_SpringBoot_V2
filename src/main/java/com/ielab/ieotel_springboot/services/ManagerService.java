package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.Manager;

import java.util.List;

public interface ManagerService {

    public List<Manager> listManager();
    public Manager showManager(String id);
    public Manager showManagerLib(String lib);
    public Manager saveManager(Manager managerType);
    public Manager updateManager(String id, Manager managerType) ;
    public void deleteManager(String id);
}
