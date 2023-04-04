package StackOfStrings;


import java.util.ArrayList;
import java.util.List;


public class StackOfStrings {

    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        data.add(element);
    }

    public String peek() {
        return data.get(data.size() - 1);
    }

    public String pop() {
        String result = data.get(data.size() - 1);
        data.remove(data.size() - 1);

        return result;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
