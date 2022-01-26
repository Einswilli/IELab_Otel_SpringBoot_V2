package com.ielab.ieotel_springboot.implementors;

import java.util.Date;
import java.util.List;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.RoomReservation;
import com.ielab.ieotel_springboot.repositories.RoomReservationRepository;
import com.ielab.ieotel_springboot.services.RoomReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomReservationImpl implements RoomReservationService {

    @Autowired
    private RoomReservationRepository roomReservationRepository;

    @Override
    public List<RoomReservation> listRoomReservation(){
        return this.roomReservationRepository.findAll();
    }

    @Override
    public RoomReservation showRoomReservation(String id){
        return this.roomReservationRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("RoomReservatio not found for id: "+id));
    }

    @Override
    public List<RoomReservation> showRoomReservationCode(String code){
        return this.roomReservationRepository.findByCode(code);
    }

    @Override
    public RoomReservation createRoomReservation(RoomReservation roomReservation){
        roomReservation.setCreatedAt(new Date());
        return this.roomReservationRepository.save(roomReservation);
    }

    @Override
    public RoomReservation updateRoomReservation(String id, RoomReservation roomReservation){
        RoomReservation roomReservationMod = roomReservationRepository.findById(id)
                        .orElseThrow(()-> new NotFoundException("Room reservation not found for id: "+id));
        roomReservationMod.setCode(roomReservation.getCode());
        roomReservationMod.setLib(roomReservation.getLib());
        roomReservationMod.setDate_Res(roomReservation.getDate_Res());
        roomReservationMod.setDate_Deb(roomReservation.getDate_Fin());
        roomReservationMod.setCost(roomReservation.getCost());
        roomReservationMod.setRooms(roomReservation.getRooms());
        roomReservationMod.setClient(roomReservation.getClient());
        roomReservationMod.setAnnul(roomReservation.isAnnul());
        roomReservationMod.setValidate(roomReservation.isValidate());
        return this.roomReservationRepository.save(roomReservationMod);
    }

    @Override
    public void deleteRoomReservation(String id){
        roomReservationRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("RoomType not found for this id::" + id));
        roomReservationRepository.deleteById(id);
    }

    
}
