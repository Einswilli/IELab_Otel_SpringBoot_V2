package com.ielab.ieotel_springboot.controllers;

import com.google.common.reflect.TypeToken;
import com.ielab.ieotel_springboot.implementors.ClientImpl;
import com.ielab.ieotel_springboot.models.*;
import com.ielab.ieotel_springboot.repositories.*;
import com.ielab.ieotel_springboot.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
@RestController
@RequestMapping("/ieotel/api/Client")
public class ClientController {
    
    @Autowired
    private ClientService cltService;
    private ClientRepository crepo;
    private String msg;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveClient(@RequestBody Client clt) {
        //trying to verify if the client AlreadyExists!
        clt.setCode(this.GenCode(clt));
        List<Client> v=this.cltService.existsByCode(clt.getCode());
        System.out.println(clt.getCode());

        try{
            if(!v.isEmpty()){

                //Client c=this.cltService.showClientByCode(clt.getCode());
                this.msg="Ce Client exist déjà...";
            }else{
                // Cool We gonna save him!
                
                cltService.saveClient(clt);
                this.msg= "Client enregistrée...";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return new ResponseEntity(this.msg, HttpStatus.OK);
    };
    

    @GetMapping(value = "/all")
    public List<Client> getAllClients() {
        TypeToken<List<Client>> typeToken = new TypeToken<List<Client>>(Client.class){};
        List<Client> list = cltService.listClient();
        return modelMapper.map(list, typeToken.getType());
    }

    @GetMapping(value = "/show/ById/{id}")
    public Client showClient(@PathVariable(value = "id") String id){
        return this.cltService.showClient(id);
    }

    @GetMapping(value="/show/ByCode/{code}")
    public Client showCLientByCode(@PathVariable(value = "code") String code){
        return this.cltService.showClientByCode(code);
    }

    private String GenCode(Client c){
        List<Client> list = cltService.listClient();
        String code;
        try{
            code=""+ZonedDateTime.now().getYear()+"000"+list.size()+""+c.getFirstName().substring(0, 2)+c.getTel().substring(0, 3)+c.getLastName().substring(1, 3)+c.getTel().substring(c.getTel().length()-2, c.getTel().length());
        }catch(Exception e){
            System.out.println(e.getMessage());
            code="Code generation error";
        }
        return code;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateCommand(@PathVariable("id") String id, @RequestBody Client client) {
        if (this.crepo.existsById(id)) {
            return new ResponseEntity("Client By ID:" + id+" Not found", HttpStatus.NOT_FOUND);
        } else {
            this.cltService.updateClient(id, client);
            return new ResponseEntity("Client updated succesfully!", HttpStatus.OK);
        }
    }
}
