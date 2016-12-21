package com.mycompany.graphApp;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Created by Daria Serebryakova on 21.12.2016.
 *
 */
public class GraphBuilder {
    public static void sparseMultigraphBuild() {

        Graph<MyVertex, MyEdge> graph = new SparseMultigraph<MyVertex, MyEdge>();

        MyVertex v1 = new MyVertex(1);
        MyVertex v2 = new MyVertex(2);
        MyVertex v3 = new MyVertex(3);
        MyVertex v4 = new MyVertex(4);
        MyVertex v5 = new MyVertex(5);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);


        graph.addEdge(new MyEdge("Edge-A"), v1, v2, EdgeType.DIRECTED);
        graph.addEdge(new MyEdge("Edge-B"), v2, v3, EdgeType.DIRECTED);
        graph.addEdge(new MyEdge("Edge-C"), v3, v2, EdgeType.DIRECTED);
        graph.addEdge(new MyEdge("Edge-D"), v1, v5, EdgeType.DIRECTED);
        graph.addEdge(new MyEdge("Edge-E"), v4, v3, EdgeType.DIRECTED);
        graph.addEdge(new MyEdge("Edge-F"), v2, v5, EdgeType.DIRECTED);

        System.out.println("graph: \n" + graph.toString());

    }
}
