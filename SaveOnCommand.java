package Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
//concrete command
public class SaveOnCommand implements Command {

    SaverLoader saverLoader;

    public SaveOnCommand(SaverLoader saverLoader) {
        this.saverLoader = saverLoader;
    }

    public void execute() {
        try {
            saverLoader.save();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SaveOnCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
