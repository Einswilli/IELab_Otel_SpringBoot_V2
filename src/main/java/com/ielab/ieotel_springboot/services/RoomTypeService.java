package com.ielab.ieotel_springboot.services;


import com.ielab.ieotel_springboot.models.DrinkType;
import com.ielab.ieotel_springboot.models.RoomType;

import java.util.List;

public interface RoomTypeService {

    public List<RoomType> listRoomType();

    public RoomType showRoomType(String id);

    public RoomType createRoomType(RoomType roomType);

    public RoomType updateRoomType(String id, RoomType roomType);

    public boolean deleteRoomType(String id);

    public List<RoomType> showRoomByLib(String lib);

}