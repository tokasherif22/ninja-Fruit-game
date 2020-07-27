package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Load {

    String time;
    String score;
    String lives;
    String strategy;
    String isDead;

    public String getTime() {
        return time;
    }

    public String getScore() {
        return score;
    }

    public String getLives() {
        return lives;
    }

    public String getStrategy() {
        return strategy;
    }

    public String getIsDead() {
        return isDead;
    }
    

    public void load_file() {
        try {

            File fXmlFile = new File("C:\\Users\\user\\Documents\\NetBeansProjects\\Ninja\\Ninja\\src\\Model\\SaveLoad.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Ninja");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\n Current Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    time = eElement.getElementsByTagName("Time").item(0).getTextContent();
                    lives = eElement.getElementsByTagName("Lives").item(0).getTextContent();
                    score = eElement.getElementsByTagName("HighestScore").item(0).getTextContent();
                    strategy = eElement.getElementsByTagName("StrategySpeed").item(0).getTextContent();
                    isDead= eElement.getElementsByTagName("StrategySpeed").item(0).getTextContent();
                     
                    //System.out.println("Time: " + eElement.getElementsByTagName("Time").item(0).getTextContent());
//                    System.out.println("Lives : " + eElement.getElementsByTagName("Lives").item(0).getTextContent());
//                    System.out.println("Score : " + eElement.getElementsByTagName("HighestScore").item(0).getTextContent());
//                    System.out.println("Strategy : " + eElement.getElementsByTagName("Strategy").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
