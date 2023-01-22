package dataStructure.listStructure;

public class Patient implements Comparable<Patient>{
    private String name;
    private int priority;
    // patients with the same priority: first-in, first-out
    private int order;
    static int counter = 100;
    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.order = counter--;
    }
    @Override
    public String toString() {
        return name + "(priority:" + priority + ")";
    }
    public int compareTo(Patient o) {
        if(this.priority > o.priority)
            return 1;
        else if(this.priority == o.priority)
            return this.order - o.order;
        else
            return -1;
    }
}

