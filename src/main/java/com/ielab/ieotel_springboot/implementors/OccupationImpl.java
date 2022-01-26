package com.ielab.ieotel_springboot.implementors;

import java.util.Date;
import java.util.List;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Occupation;
import com.ielab.ieotel_springboot.repositories.OccupationRepository;
import com.ielab.ieotel_springboot.services.OccupationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OccupationImpl implements OccupationService {

    @Autowired
    OccupationRepository occupationRepository;

    @Override
    public List<Occupation> listOccupation(){
        return occupationRepository.findAll();
    }

    @Override
    public Occupation showOccupation(String id){
        return occupationRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Occupation not found for id : "+id));
    }

    @Override
    public List<Occupation> showOccupations(String lib) {
        return occupationRepository.findByLib(lib);
    }

    @Override
    public Occupation createOccupation(Occupation occupation){
        occupation.setCreatedAt(new Date());
        return occupationRepository.save(occupation);
    }

    @Override
    public Occupation updateOccupation(String id, Occupation occupation){
        Occupation occupationMod = occupationRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Occupation not found for id: "+id));
        occupationMod.setLib(occupation.getLib());
        occupationMod.setDated(occupation.getDated());
        occupationMod.setDatef(occupation.getDatef());
        occupationMod.setClient(occupation.getClient());
        occupationMod.setRoom(occupation.getRoom());
        occupationMod.setUpdatedAt(occupation.getUpdatedAt());
        return occupationRepository.save(occupationMod);
    }

    @Override
    public void deleteOccupation(String id){
        Occupation occupationDel = this.occupationRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Occupation not found for id: "+id));
        occupationRepository.deleteById(id);
    }

    
}
