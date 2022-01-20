package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.ConsoRoom;
import com.ielab.ieotel_springboot.repositories.ConsoRoomRepository;
import com.ielab.ieotel_springboot.services.ConsoRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsoRoomImpl implements ConsoRoomService {
    @Autowired
    private ConsoRoomRepository consoRoomRepository;

    @Override
    public List<ConsoRoom> listConsoRoom() {
        //logger.ListReadLogging("ConsoRoom","");
        return consoRoomRepository.findAll();
    }

    @Override
    public ConsoRoom showConsoRoom(String id) {
        //logger.DeatailLogging("ConsoRoom","");
        return consoRoomRepository.findById(id).orElseThrow(()-> new NotFoundException("Conso Room not found for this id::"+id));
    }

    @Override
    public ConsoRoom crateConsoRoom(ConsoRoom consoRoom) {
        // logger.CreationLogging("ConsoRoom","", consoRoom.toString());
        consoRoom.setCreateAt(new Date());
        return  consoRoomRepository.save(consoRoom);
    }

    @Override
    public ConsoRoom updateConsoRoom(String id, ConsoRoom consoRoom) {
        ConsoRoom consoRoom1=consoRoomRepository.findById(id).orElseThrow(()-> new NotFoundException("Conso room not found for this id::"+id));
        consoRoom1.setRoom(consoRoom.getRoom());
        consoRoom1.setCode(consoRoom.getCode());
        consoRoom1.setCust(consoRoom.getCust());
        consoRoom1.setDrinks(consoRoom.getDrinks());
        consoRoom1.setDate(consoRoom.getDate());
        consoRoom1.setUpdateAt(new Date());
        // logger.UpdateLogging("ConsoRoom","",consoRoom.toString(),consoRoom1.toString());

       return consoRoomRepository.save(consoRoom1);
    }
}
