package Additives;

public abstract class Additive {
    private double dissolutionTime;
    private int count;
    private String name;
    public Additive(int count, String name, double dissolutionTime){
        this.count = count;
        this.name = name;
        this.dissolutionTime = dissolutionTime;
    }

    public String getName(){
        return this.name;
    }
    public int getCount(){
        return this.count;
    }
    public double getDissolutionTime(){
        return this.dissolutionTime;
    }
}
