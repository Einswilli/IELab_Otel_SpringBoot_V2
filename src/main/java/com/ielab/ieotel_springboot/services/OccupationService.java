package com.ielab.ieotel_springboot.services;

import java.util.List;

import com.ielab.ieotel_springboot.models.Occupation;

public interface OccupationService {

    public List<Occupation> listOccupation();

    public Occupation showOccupation(String id);

    public Occupation createOccupation(Occupation occupation);

    public Occupation updateOccupation(String id, Occupation occupation);

    public void deleteOccupation(String id);


    
}
