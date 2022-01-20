package com.ielab.ieotel_springboot.services;
import java.util.List;

import com.ielab.ieotel_springboot.models.*;

import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    

    public Client saveClient(Client cilent);
    public Client updateClient(String id,Client client);
    public Client showClient(String id);
    public Client showClientByCode(String code);
    public void deleteClient(String id);
    public List<Client> listClient();
    public List<Client> existsByCode(String id);
}
