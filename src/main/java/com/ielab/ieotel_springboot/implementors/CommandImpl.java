package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Command;
import com.ielab.ieotel_springboot.repositories.CommandRepository;
import com.ielab.ieotel_springboot.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommandImpl implements CommandService {

    @Autowired
    private CommandRepository commandRepository;

    @Override
    public List<Command> listCommand() {
        //logger.ListReadLogging("Event","");
        return commandRepository.findAll();
    }

    @Override
    public Command showCommand(String id) {
        // logger.DeatailLogging("Event","");
        return commandRepository.findById(id).orElseThrow(()-> new NotFoundException("Command Not found By id::"+id));
    }

    @Override
    public Command createCommand(Command command) {
        //logger.CreationLogging("Command","",command.toString());
        command.setCreatedAt(new Date());
        return commandRepository.save(command);
    }

    @Override
    public Command updateCommand(String id, Command command) {
        Command command1= commandRepository.findById(id).orElseThrow(()-> new NotFoundException("Command Not found By id::"+id));
        command1.setCust(command.getCust());
        command1.setDelivred(command.isDelivred());
        command1.setDrink(command.getDrink());
        command1.setDestination(command.getDestination());
        //command1.setFood(command.getFood());
        command1.setValidated(command.isValidated());
        command1.setUpdatedAt(command.getUpdatedAt());
        //logger.UpdateLogging("Command","",command.toString(),command1.toString());

        return commandRepository.save(command);

    }
}
