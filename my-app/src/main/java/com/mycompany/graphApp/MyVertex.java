package com.mycompany.graphApp;

/**
 * Created by Daria Serebryakova on 21.12.2016.
 */
public class MyVertex {
    private int node;

    public MyVertex(int node){
        this.node = node;
    }

    @Override
    public String toString() {
        return "V"+ node;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }
}
