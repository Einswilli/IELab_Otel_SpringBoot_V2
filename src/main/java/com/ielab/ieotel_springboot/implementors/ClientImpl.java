package com.ielab.ieotel_springboot.implementors;

import java.util.List;

import com.ielab.ieotel_springboot.models.Client;
import com.ielab.ieotel_springboot.repositories.ClientRepository;
import com.ielab.ieotel_springboot.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientImpl implements ClientService{
    

    @Autowired
    private ClientRepository clientRepo;

    @Override
    public Client saveClient(Client clt){
        return this.clientRepo.save(clt);
    }

    
    @Override
    public Client updateClient(String id, Client clt){

        Client c=this.clientRepo.findClientById(id);
        c.setAdress(clt.getAdress());
        c.setBirthday(clt.getBirthday());
        c.setCode(clt.getCode());
        c.setCreatedAt(clt.getCreatedAt());
        c.setTel(clt.getTel());
        c.setDeletedAt(clt.getDeletedAt());
        c.setDeleted(clt.isDeleted());
        c.setEmail(clt.getEmail());
        c.setFirstName(clt.getFirstName());
        c.setLastName(clt.getLastName());
        c.setUpdatedAt(clt.getUpdatedAt());

        return this.clientRepo.save(c);
    }

    @Override
    public List<Client> listClient(){
        return this.clientRepo.findAll();
    }

    @Override
    public void deleteClient(String id){

        this.clientRepo.delete(this.clientRepo.findClientById(id));
    }

    @Override
    public Client showClient(String id){
        return this.clientRepo.findClientById(id);
    }

    @Override
    public Client showClientByCode(String code){
        return this.clientRepo.findClientByCode(code);
    }

    @Override
    public List<Client> existsByCode(String code){
        return this.clientRepo.existsByCode(code);
    }

}
