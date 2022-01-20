package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Drink;
import com.ielab.ieotel_springboot.models.DrinkType;
import com.ielab.ieotel_springboot.repositories.DrinkRepository;
import com.ielab.ieotel_springboot.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DrinkImpl implements DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    //Logger logger = new Logger();
    @Override
    public Drink createDrink(Drink drink) {
            drink.setCreateAt(new Date());
            return this.drinkRepository.save(drink);
            //logger.CreationLogging("Drink", "Auteur");
        }


    @Override
    public Drink updateDrink(String id, Drink drink) {

        Drink drink1 = this.drinkRepository.findById(id).orElseThrow(()->new NotFoundException("Drink not found for this id::"+id));
        drink1.setName(drink.getName());
        drink1.setLib(drink.getLib());
        drink1.setQuantity(drink.getQuantity());
        drink1.setPrice(drink.getPrice());
        drink1.setDrinkType(drink.getDrinkType());
        drink1.setUpdateAt(new Date());
        return drinkRepository.save(drink1);
        //logger.UpdateLogging("Drink", "Auteur", roomType.toString());
    }

    @Override
    public boolean deleteDrink(String id) {
        Drink drink1 = this.drinkRepository.findById(id).orElseThrow(()->new NotFoundException("Drink not found for this id: "+id));
        drinkRepository.deleteById(id);
        return true;
        //logger.DeletionLogging("Drink", "Auteur", roomType1.toString());
    }

    @Override
    public List<Drink> listDrinkType() {
        return this.drinkRepository.findAll();
        //logger.ListReadLogging("Drink", "Auteur");
    }

    @Override
    public Drink showDrink(String id) {

        return this.drinkRepository.findById(id).orElseThrow(()-> new NotFoundException("DrinkType not found for this id:"+id));
        //logger.ListReadLogging("Drink", "Auteur");
    }

    @Override
    public List<Drink> showDrinkbyNamePriceAnddrinkType(String name, Float price, DrinkType drinkType) {
        return drinkRepository.findByNameAndPriceAndDrinkType(name,price,drinkType);
    }
}
  /*  @Autowired
    private DrinkRepository drinkRepository;
    //Logger logger = new Logger();


    public List<Drink> listDrink(){
        return this.drinkRepository.findAll();
        //logger.ListReadLogging("Drink", "Auteur");
    }

    public Drink showDrink(Long id){

        return this.drinkRepository.findById(id).orElseThrow(()-> new NotFoundException("DrinkType not found for this id:"+id));
        //logger.ListReadLogging("Drink", "Auteur");
    }

    public boolean createDrink(Drink drink){
        Optional<Drink> drinkOptional = this.drinkRepository.findByDrink(drink.getName());
        if(drinkOptional.isPresent()){
            new AlreadyExistsException("This DrinkType is already exist");
            return false;
        }else{
            drinkRepository.save(drink);
            return true;
            //logger.CreationLogging("Drink", "Auteur");
        }

    }

    public boolean updateDrink(Long id, Drink drink){

        Drink drink1 = this.drinkRepository.findById(id).orElseThrow(()->new NotFoundException("Drink not found for this id::"+id));
        drink1.setName(drink.getName());
        drink1.setLib(drink.getLib());
        drink1.setQuantity(drink.getQuantity());
        drink1.setPrice(drink.getPrice());
        drink1.setDrinkType(drink.getDrinkType());
        drinkRepository.save(drink1);
        return true;
        //logger.UpdateLogging("Drink", "Auteur", roomType.toString());

    }

    public boolean deleteDrink(Long id){
        Drink drink1 = this.drinkRepository.findById(id).orElseThrow(()->new NotFoundException("Drink not found for this id: "+id));
        drinkRepository.deleteById(id);
        return true;
        //logger.DeletionLogging("Drink", "Auteur", roomType1.toString());
  }*/