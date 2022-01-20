package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Room;
import com.ielab.ieotel_springboot.repositories.RoomRepository;
import com.ielab.ieotel_springboot.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RoomImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<Room> listRoom() {
        return roomRepository.findAll();
        // logger.ListReadLogging("Room",);
    }

    @Override
    public Room showRoom(String id) {
        return roomRepository.findById(id).orElseThrow(()->new NotFoundException("Room not found for this id :: " + id));
    }

    @Override
    public Room createRoom(Room room) {
        room.setCreatedAt(new Date());
        return roomRepository.save(room);
        //logger.CreationLogging(room.toString(),);
    }

    @Override
    public Room updateRoom(String id, Room room) {
        Room room1=roomRepository.findById(id).orElseThrow(()->new NotFoundException("Room not found for this id::"+id));
        room1.setState(room.getState());
        room1.setRoomType(room.getRoomType());
        room1.setCode(room.getCode());
        room1.setDrinks(room.getDrinks());
        room1.setStatut(room.getStatut());
        room1.setUpdatedAt(new Date(System.currentTimeMillis()));
        //logger.UpdateLogging("Room","",room.toString(),room1.toString());
        return roomRepository.save(room1);
    }

    @Override
    public void deleteRoom(String id) {
        Room room1=roomRepository.findById(id).orElseThrow(()->new NotFoundException("Room not found for this id::"+id));
        roomRepository.deleteById(id);
        //logger.DeletionLogging("Room","",room1.toString());
    }

    @Override
    public List<Room> ShowRoombyCode(String code) {
        return roomRepository.findByCode(code);
    }
}
