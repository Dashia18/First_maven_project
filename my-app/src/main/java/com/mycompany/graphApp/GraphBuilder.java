package com.mycompany.graphApp;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.apache.commons.collections15.Transformer;

import java.util.List;

/**
 * Created by Daria Serebryakova on 21.12.2016.
 *
 */
class GraphBuilder {
     static void sparseMultigraphBuild() {

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

        MyEdge edgeA = new MyEdge("Edge-A",1);
        MyEdge edgeB = new MyEdge("Edge-B", 3);
        MyEdge edgeC = new MyEdge("Edge-C", 4);
        MyEdge edgeD = new MyEdge("Edge-D", 3);
        MyEdge edgeE = new MyEdge("Edge-E", 2);
        MyEdge edgeF = new MyEdge("Edge-F",1);

        graph.addEdge(edgeA, v1, v2, EdgeType.DIRECTED);
        graph.addEdge(edgeB, v2, v3, EdgeType.DIRECTED);
        graph.addEdge(edgeC, v3, v2, EdgeType.DIRECTED);
        graph.addEdge(edgeD, v1, v5, EdgeType.DIRECTED);
        graph.addEdge(edgeE, v4, v3, EdgeType.DIRECTED);
        graph.addEdge(edgeF, v2, v5, EdgeType.DIRECTED);




        System.out.println("graph: \n" + graph.toString());


        //Minimal path for unweighted graph
            DijkstraShortestPath<MyVertex,MyEdge> algWeight2 = new DijkstraShortestPath<MyVertex,MyEdge>(graph);
            List<MyEdge> edgeList2 = algWeight2.getPath(v1,v5);
            Number dist2 = algWeight2.getDistance(v1, v5);

            System.out.println("The shortest unweighted path from" + v1 +" to " + v5 + " is:");
            System.out.println(edgeList2.toString());
            System.out.println("and the length of the path is: " + dist2);

        //Minimal path with for weighted graph
            Transformer<MyEdge, Double> wtTransformer = new Transformer<MyEdge,Double>() {
                public Double transform(MyEdge edge) {
                    return edge.getWeight();
                }
            };
            DijkstraShortestPath<MyVertex,MyEdge> algWeight = new DijkstraShortestPath<MyVertex,MyEdge>(graph, wtTransformer);
            List<MyEdge> edgeList1 = algWeight.getPath(v1,v5);
            Number dist1 = algWeight.getDistance(v1, v5);

            System.out.println("\"The shortest path from" + v1 +" to " + v5 + " is:");
            System.out.println(edgeList1.toString());
            System.out.println("and the length of the path is: " + dist1);




    }

}
