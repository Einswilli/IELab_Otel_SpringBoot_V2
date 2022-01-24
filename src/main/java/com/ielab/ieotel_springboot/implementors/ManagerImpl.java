package com.ielab.ieotel_springboot.implementors;


import java.util.Date;
import java.util.List;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Manager;
import com.ielab.ieotel_springboot.repositories.ManagerRepository;
import com.ielab.ieotel_springboot.services.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerImpl implements ManagerService{

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public List<Manager> listManager() {
        return managerRepository.findAll();
        //Logg the action
    }

    @Override
    public Manager showManager(String id) {
        return managerRepository.findById(id)
            .orElseThrow(()->new NotFoundException("Manager not found for id: "+id));
    }

    @Override
    public Manager showManagerLib(String code) {
        return managerRepository.findByCode(code)
                .orElseThrow(()->new NotFoundException("Manager not found for code: "+code));
    }

    @Override
    public Manager saveManager(Manager manager) {
        manager.setCreatedAt(new Date());
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManager(String id, Manager manager) {
        Manager managerMod = managerRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Manager type not found for id: "+id));
        managerMod.setCode(manager.getCode());
        managerMod.setFirstName(manager.getFirstName());
        managerMod.setLastName(manager.getLastName());
        managerMod.setBirthday(manager.getBirthday());
        managerMod.setTel(manager.getTel());
        managerMod.setEmail(manager.getEmail());
        managerMod.setAddress(manager.getAddress());
        managerMod.setGrade(manager.getGrade());
        managerMod.setManagerType(manager.getManagerType());
        managerMod.setActivated(manager.isActivated());
        managerMod.setUpdatedAt(new Date());
        return managerRepository.save(managerMod);
    }

    @Override
    public void deleteManager(String id) {
        Manager managerDel = this.managerRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Manager not found for id: "+id));
        managerDel.setDeleted(true);
        managerDel.setDeletedAt(new Date());
        managerRepository.save(managerDel);
    
    }

}
