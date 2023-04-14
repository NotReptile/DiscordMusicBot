package Reptile.DiscordMusicBot;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private final List<ICommand> commands = new ArrayList<>();

    public CommandManager(){

    }
    public void addCommand(ICommand command){
        boolean nameFound = this.commands.stream().anyMatch((it)
                -> it.getName().equalsIgnoreCase(command.getName()));
        if (nameFound){
            throw new IllegalArgumentException("A command with this name is already exist");
        }

        commands.add(command);
    }
    public List<ICommand> getCommands(){return commands;}

    @Nullable
    public ICommand getCommand(String search){
        String searchLower = search.toLowerCase();

        for (ICommand command : this.commands){
            if (command.getName().equals(searchLower)){
                return command;
            }
        }

        return null;
    }

}
