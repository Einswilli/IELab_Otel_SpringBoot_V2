package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.RoomType;
import com.ielab.ieotel_springboot.repositories.RoomTypeRepository;
import com.ielab.ieotel_springboot.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomTypeImpl implements RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomType> listRoomType() {
        //logger.ListReadLogging("drinkType","");
        return roomTypeRepository.findAll();
    }

    @Override
    public RoomType showRoomType(String id) {
        //logger.DeatailLogging("drinkType","");
        return roomTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("RoomType not found for this id:" + id));
    }

    @Override
    public RoomType createRoomType(RoomType roomType) {
        roomType.setCreatedAt(new Date());
        return this.roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType updateRoomType(String id, RoomType roomType) {
        RoomType roomType1 = roomTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Roomtype not found for this id::" + id));
        roomType1.setLib(roomType.getLib());
        roomType1.setUpdatedAt(new Date());
        //logger.UpdateLogging("drinkType","",drinkType.toString(),drinkType1.toString());
        return roomTypeRepository.save(roomType1);
    }
    @Override
    public boolean deleteRoomType(String id) {
        // logger.DeletionLogging("drinkType","","");
        roomTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("RoomType not found for this id::" + id));
        roomTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<RoomType> showRoomByLib(String lib) {
        return roomTypeRepository.findByLib(lib);
    }
}
