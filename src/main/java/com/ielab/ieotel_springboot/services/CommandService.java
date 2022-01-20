package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.Command;

import java.util.List;

public interface CommandService {
    public List<Command> listCommand();

    public Command showCommand(String id);

    public Command createCommand(Command command);

    public Command updateCommand(String id, Command command) ;
}
