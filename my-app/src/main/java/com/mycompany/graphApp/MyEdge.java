package com.mycompany.graphApp;

/**
 * Created by Daria Serebryakova on 21.12.2016.
 */
public class MyEdge {
    private String edge;
    private double capacity;
    private double weight;

    public MyEdge(String edge){
        this.edge = edge;
    }

    public MyEdge(String edge, double weight) {
        this.edge = edge;
        this.weight = weight;
    }

    public MyEdge(String edge, double weight, double capacity) {
        this.edge = edge;
        this.capacity = capacity;
        this.weight = weight;
    }
    public MyEdge(double weight, double capacity) {
        this.capacity = capacity;
        this.weight = weight;
    }
    public double getCapacity() {
        return capacity;
    }

    public double getWeight() {
        return weight;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return edge ;
    }

    public String getEdge() {
        return edge;
    }

    public void setEdge(String edge) {
        this.edge = edge;
    }
}
