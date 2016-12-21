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

        Graph<Integer, String> graph = new SparseMultigraph<Integer, String>();

        graph.addVertex((Integer)1);
        graph.addVertex((Integer)2);
        graph.addVertex((Integer)3);
        graph.addVertex((Integer)4);
        graph.addVertex((Integer)5);
        graph.addVertex((Integer)6);
        graph.addVertex((Integer)7);

        graph.addEdge("Edge-A", 1, 2, EdgeType.DIRECTED);
        graph.addEdge("Edge-B", 2, 3, EdgeType.DIRECTED);
        graph.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
        graph.addEdge("Edge-D", 1, 5, EdgeType.DIRECTED);
        graph.addEdge("Edge-E", 6, 7, EdgeType.DIRECTED);
        graph.addEdge("Edge-F", 7, 3, EdgeType.DIRECTED);

        System.out.println("The graph g = " + graph.toString());

    }
}
