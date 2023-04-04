package commands;

import java.io.IOException;
import java.util.Objects;

public abstract class Command {
    private final String name;
    private final String description;

    public Command(String name, String description){
        this.name = name;
        this.description = description;
    }

  //  public abstract void execute() throws IOException;
   // public abstract void execute(String argument) throws IOException;
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return name.equals(command.name) && description.equals(command.description);
    }

    @Override
    public String toString() {
        return "Command{" +
                "name = '" + name + "', description = '" +
                description + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
