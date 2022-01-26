package com.ielab.ieotel_springboot.services;

import java.util.List;

import com.ielab.ieotel_springboot.models.RoomReservation;

public interface RoomReservationService {

    public List<RoomReservation> listRoomReservation();

    public RoomReservation showRoomReservation(String id);

    public List<RoomReservation> showRoomReservationCode(String code);

    public RoomReservation createRoomReservation(RoomReservation roomReservation);

    public RoomReservation updateRoomReservation(String id, RoomReservation roomReservation) ;

    public void deleteRoomReservation(String id);    
}
