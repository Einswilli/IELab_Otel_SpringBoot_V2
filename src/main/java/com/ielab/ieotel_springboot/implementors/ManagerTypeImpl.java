package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.ManagerType;
import com.ielab.ieotel_springboot.repositories.ManagerTypeRepository;
import com.ielab.ieotel_springboot.services.ManagerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ManagerTypeImpl implements ManagerTypeService {
    @Autowired
    ManagerTypeRepository managerTypeRepository;

    @Override
    public List<ManagerType> listManagerType() {
        return managerTypeRepository.findAll();
        //Logg the action
    }

    @Override
    public ManagerType showManagerType(String id) {
        return managerTypeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Manager type not found for this id: "+id));
    }

    @Override
    public ManagerType showManagerTypeLib(String lib) {
        return managerTypeRepository.findByLib(lib)
                .orElseThrow(()->new NotFoundException("Manager not found for lib: "+lib));
    }

    @Override
    public ManagerType saveManagerType(ManagerType managerType) {
        managerType.setCreatedAt(new Date());
        return managerTypeRepository.save(managerType);
    }

    @Override
    public ManagerType updateManagerType(String id, ManagerType managerType) {
        ManagerType managerTypeMod = managerTypeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Manager type not found for id: "+id));
        managerTypeMod.setUpdatedAt(new Date());
        managerTypeMod.setLib(managerType.getLib());
        return managerTypeRepository.save(managerTypeMod);
    }

    @Override
    public void deleteManagerType(String id) {
        ManagerType managerTypeDel = this.managerTypeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Manager type not found for id: "+id));
        managerTypeRepository.deleteById(id);

    }
}
