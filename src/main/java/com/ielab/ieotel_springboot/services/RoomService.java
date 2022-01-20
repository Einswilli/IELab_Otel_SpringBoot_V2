package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.Room;

import java.util.List;

public interface RoomService {
    public List<Room> listRoom();

    public Room showRoom(String id);

    public Room createRoom(Room room);

    public Room updateRoom(String id, Room room) ;

    public void deleteRoom(String id);

    public List<Room> ShowRoombyCode(String code);
}
