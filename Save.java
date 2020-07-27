package Model;

import Controller.Player;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Save {

    Player player;
    Strategy strategy;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void save_file() throws ParserConfigurationException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        //add elements to Document

        Element rootElement = doc.createElementNS("C:\\Users\\tokay\\Downloads\\NinjaFinal\\Ninja\\src\\Model\\SaveLoad.xml", "Ninja");
        //append root element to document
        doc.appendChild(rootElement);

        //append first child element to root element
        rootElement.appendChild(getSavings(doc, player.getTime(), player.getXMLLives(), player.getXMLscore(), player.getStrategyValue()));

        //for output to file, console
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        }
        //for pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);

        //write to console or file
        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(new File("C:\\Users\\tokay\\Downloads\\NinjaFinal\\Ninja\\src\\Model\\SaveLoad.xml"));

        //write data
        try {
            transformer.transform(source, console);
            transformer.transform(source, file);
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }

        System.out.println("DONE");

    }

    //.........................................................
    private static Node getSavings(Document doc, int time, int lives, int highestScore, int strategy) {
        Element ninjaGame = doc.createElement("Ninja");
        ninjaGame.appendChild(getNinjaGame(doc, ninjaGame, "Time", String.valueOf(time)));
        ninjaGame.appendChild(getNinjaGame(doc, ninjaGame, "Lives", String.valueOf(lives)));
        ninjaGame.appendChild(getNinjaGame(doc, ninjaGame, "HighestScore", String.valueOf(highestScore)));
        ninjaGame.appendChild(getNinjaGame(doc, ninjaGame, "StrategySpeed", String.valueOf(strategy)));

        return ninjaGame;
    }

    //utility method to create text node
    private static Node getNinjaGame(Document doc, Element ninjaGame, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));

        return node;
    }

}
