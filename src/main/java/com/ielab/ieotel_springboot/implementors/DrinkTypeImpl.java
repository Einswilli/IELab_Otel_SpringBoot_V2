package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.models.DrinkType;
import com.ielab.ieotel_springboot.repositories.DrinkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DrinkTypeImpl {
    @Autowired
    private DrinkTypeRepository drinkTypeRepository;
    //private Logger logger;

    @Override
    public boolean createDrinkType(DrinkType drinkType) {
        Optional<DrinkType> drinkTypeOptional= drinkTypeRepository.FindByDrinktype(drinkType.getLib());
        if(drinkTypeOptional.isPresent()){
            new ("This DrinkType is already exist");
            return false;
        }else{
            drinkType.setCreatedAt(new Date());
            drinkTypeRepository.save(drinkType);
            return true;
        }
        // logger.CreationLogging("DrinkType","",drinkType.toString());
    }

    @Override
    public boolean updateDrinkType(Long id, DrinkType drinkType) {
        DrinkType drinkType1=drinkTypeRepository.findById(id).orElseThrow(()->new NotFoundException("DrinkType not found for this id::"+id));
        drinkType1.setLib(drinkType.getLib());
        drinkType1.setUpdatedAt(new Date());
        //logger.UpdateLogging("drinkType","",drinkType.toString(),drinkType1.toString());
        drinkTypeRepository.save(drinkType1);
        return true;
    }

    @Override
    public boolean deleteDrinkType(Long id) {
        // logger.DeletionLogging("drinkType","","");
        drinkTypeRepository.findById(id).orElseThrow(()->new NotFoundException("DrinkType not found for this id::"+id));
        drinkTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<DrinkType> listDrinkType() {
        //logger.ListReadLogging("drinkType","");
        return drinkTypeRepository.findAll();
    }

    @Override
    public DrinkType showDrinkType(Long id) {
        //logger.DeatailLogging("drinkType","");
        return drinkTypeRepository.findById(id).orElseThrow(()-> new NotFoundException("DrinkType not found for this id:"+id));
    }
}
