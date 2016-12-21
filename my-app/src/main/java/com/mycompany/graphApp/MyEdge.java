package com.mycompany.graphApp;

/**
 * Created by Daria Serebryakova on 21.12.2016.
 */
public class MyEdge {
    private String edge;

    public MyEdge(String edge){
        this.edge = edge;
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
