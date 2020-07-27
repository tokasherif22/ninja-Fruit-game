package Controller;

import view.DeadScene;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import Model.Caretaker;
import Model.Originator;
import Model.Save;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ParallelTransition;
import javax.xml.parsers.ParserConfigurationException;
import view.Game;

public class Player {

    private static Player instance;
    int bestScore;
    Timeline timeline;
    Timeline timeline1;
    int time = 60;
    ParallelTransition parallelTransition;
    int XMLTime;
    int XMLLives;
    int XMLscore;
    int strategyValue;
    Save save;

    public static synchronized Player getInstance() {
        
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public int getTime() {
        return time;
    }

    public void setTimeXML(int time) {
        this.time = time;
    }

    public void setTime() {
        this.time = time = time - 1;
        if (time != 0) {

            XMLTime = time;
            XMLLives = livesLeft;
            XMLscore = score;

        }
    }

    public void setStrategyValue(int strategyValue) {
        this.strategyValue = strategyValue;
    }

    public int getXMLLives() {
        return XMLLives;
    }

    public int getXMLscore() {
        return XMLscore;
    }

    public int getXMLTime() {
        return XMLTime;
    }

    public void setTime(int time) {

        this.time = time;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public void setTimeline1(Timeline timeline1) {
        this.timeline1 = timeline1;
    }

    public void setParallelTransition(ParallelTransition parallelTransition) {
        this.parallelTransition = parallelTransition;
    }

    public int getStrategyValue() {
        return strategyValue;
    }

    public void setSave(Save save) {
        this.save = save;
    }

    int livesLeft = 3;
    int score = 0;
    DeadScene deadScene;
    Stage stage;
    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();

    public int getLivesLeft() {
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public boolean isDead() {

        if (livesLeft <= 0 || time == 0) {
            XMLTime = 60;
            XMLLives = 3;
            XMLscore = 0;
            try {
                save.save_file();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            setScore(0);
            setLivesLeft(3);
            setTime(60);
            timeline.stop();
            timeline1.stop();
            parallelTransition.stop();
            return true;
        }
        return false;
    }

    public void Dead() {
        XMLTime = 60;
        XMLLives = 3;
        XMLscore = 0;
        setScore(0);
        setLivesLeft(3);
        setTime(60);
        timeline.stop();
        timeline1.stop();
        parallelTransition.stop();

    }

    public void setDeadScene(DeadScene deadScene) {
        this.deadScene = deadScene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        System.out.println(score);
        return score;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void isBestScore() {
        if (caretaker.Size() == 0) {
            originator.setState(String.valueOf(score));
            caretaker.addMemento(originator.save());
            System.out.println(originator.getBestScore());
        } else {
            originator.restore(caretaker.getMemento());
            if (score > originator.getBestScore()) {
                {
                    originator.setState(String.valueOf(score));
                    caretaker.addMemento(originator.save());
                    setBestScore(originator.getBestScore());
                }

            }
        }
    }

}
