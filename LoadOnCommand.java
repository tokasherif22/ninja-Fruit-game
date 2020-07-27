package Model;


public class LoadOnCommand implements Command {

    SaverLoader saverLoader;

    public LoadOnCommand(SaverLoader saverLoader) {
        this.saverLoader = saverLoader;
    }

    public void execute() {
        saverLoader.load();
    }

}
