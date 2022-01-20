package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.DrinkType;
import com.ielab.ieotel_springboot.repositories.DrinkTypeRepository;
import com.ielab.ieotel_springboot.services.DrinkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DrinkTypeImpl  implements DrinkTypeService {
    @Autowired
    private DrinkTypeRepository drinkTypeRepository;

    @Override
    public DrinkType createDrinkType(DrinkType drinkType) {
        drinkType.setCreatedAt(new Date());
        return this.drinkTypeRepository.save(drinkType);
    }

    @Override
    public DrinkType updateDrinkType(String id, DrinkType drinkType) {
        DrinkType drinkType1 = drinkTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("DrinkType not found for this id::" + id));
        drinkType1.setLib(drinkType.getLib());
        drinkType1.setUpdatedAt(new Date());
        //logger.UpdateLogging("drinkType","",drinkType.toString(),drinkType1.toString());
        return drinkTypeRepository.save(drinkType1);

    }

    @Override
    public boolean deleteDrinkType(String id) {
        // logger.DeletionLogging("drinkType","","");
        drinkTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("DrinkType not found for this id::" + id));
        drinkTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<DrinkType> listDrinkType() {
        //logger.ListReadLogging("drinkType","");
        return drinkTypeRepository.findAll();
    }

    @Override
    public DrinkType showDrinkType(String id) {
        //logger.DeatailLogging("drinkType","");
        return drinkTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("DrinkType not found for this id:" + id));
    }

    @Override
    public List<DrinkType> showDrinkTypeByLib(String lib) {

        return drinkTypeRepository.findByLib(lib);
    }

}
