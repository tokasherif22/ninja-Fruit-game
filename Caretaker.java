package Model;

import Model.Memento;
import java.util.ArrayList;

public class Caretaker {

    private ArrayList<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getMemento() {
        return mementos.get(mementos.size() - 1);
    }

    public int Size() {
        return mementos.size();
    }
}
