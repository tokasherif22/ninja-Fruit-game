package Model;

public class Originator {

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public Memento save() {
        return new Memento(state);
    }

    public void restore(Memento m) {
        state = m.getState();
    }
    public int getBestScore(){
        return Integer.valueOf(state);
    }

}
