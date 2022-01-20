package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.ConsoRoom;

import java.util.List;

public interface ConsoRoomService {

    public List<ConsoRoom> listConsoRoom();

    public ConsoRoom showConsoRoom(String id);

    public ConsoRoom crateConsoRoom(ConsoRoom consoRoom);

    public ConsoRoom updateConsoRoom(String id, ConsoRoom consoRoom);
}
