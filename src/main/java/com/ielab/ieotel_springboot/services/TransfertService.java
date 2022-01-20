package com.ielab.ieotel_springboot.services;

import java.util.List;

import com.ielab.ieotel_springboot.models.Transfert;

public interface TransfertService {
    
    public Transfert saveTransfert(Transfert tf);

    public List<Transfert> listTransfert();

    public Transfert showTransfert(String id);
}
