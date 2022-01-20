package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.services.TransfertService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ielab.ieotel_springboot.models.*;
import com.ielab.ieotel_springboot.repositories.*;
import com.ielab.ieotel_springboot.services.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransfertImpl implements TransfertService{

    @Autowired
    private TransfertRepository tfRepo;

    @Override
    public Transfert saveTransfert(Transfert tf){
        return this.tfRepo.save(tf);
    }

    @Override
    public List<Transfert> listTransfert(){
        return this.tfRepo.findAll();
    }
    
    @Override
    public Transfert showTransfert(String ref){
        return this.tfRepo.findByReference(ref);
    }
    
}
