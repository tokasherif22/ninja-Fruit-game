package Model;

import javax.xml.parsers.ParserConfigurationException;
import view.Menu;
//reciever
public class SaverLoader {
    
    Save save;
    Load load;
    Menu menu;
    
    public void setSave(Save save) {
        this.save = save;
    }
    
    public void setLoad(Load load) {
        this.load = load;
    }
    
    public void save() throws ParserConfigurationException {
        save.save_file();
    }
    
    public void load() {
        load.load_file();
        menu.setLoadLives(Integer.valueOf(load.getLives()));
        menu.setLoadScore(Integer.valueOf(load.getScore()));
        menu.setLoadTime(Integer.valueOf(load.getTime()));
        menu.setStartegy(Integer.valueOf(load.getStrategy()));
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
}
