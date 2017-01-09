package com.mycompany.graphApp;

import edu.uci.ics.jung.algorithms.flows.EdmondsKarpMaxFlow;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Daria Serebryakova on 21.12.2016.
 *
 */
class GraphBuilder {
     static void sparseMultigraphBuild() {

         DirectedGraph<MyVertex, MyEdge> graph = new DirectedSparseMultigraph<MyVertex, MyEdge>();

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

        MyEdge edgeA = new MyEdge("Edge-A",1,96);
        MyEdge edgeB = new MyEdge("Edge-B", 3,96);
        MyEdge edgeC = new MyEdge("Edge-C", 4,96);
        MyEdge edgeD = new MyEdge("Edge-D", 3,192);
        MyEdge edgeE = new MyEdge("Edge-E", 2,96);
        MyEdge edgeF = new MyEdge("Edge-F",1,96);
        MyEdge edgeG = new MyEdge("Edge-G",1,96);

        graph.addEdge(edgeA, v1, v2, EdgeType.DIRECTED);
        graph.addEdge(edgeB, v2, v3, EdgeType.DIRECTED);
        graph.addEdge(edgeC, v3, v2, EdgeType.DIRECTED);
        graph.addEdge(edgeD, v1, v5, EdgeType.DIRECTED);
        graph.addEdge(edgeE, v4, v5, EdgeType.DIRECTED);
        graph.addEdge(edgeF, v2, v5, EdgeType.DIRECTED);
        graph.addEdge(edgeG, v3, v4, EdgeType.DIRECTED);




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






         //Max-Flow
         Transformer<MyEdge, Double> capTransformer =
                 new Transformer<MyEdge, Double>(){
                     public Double transform(MyEdge link) {
                         return link.getCapacity();
                     }
                 };
         Map<MyEdge, Double> edgeFlowMap = new HashMap<MyEdge, Double>();
         // This Factory produces new edges for use by the algorithm
         Factory<MyEdge> edgeFactory = new Factory<MyEdge>() {
             public MyEdge create() {
                 return new MyEdge(1.0, 1.0);
             }
         };

         EdmondsKarpMaxFlow<MyVertex, MyEdge> alg =
                 new EdmondsKarpMaxFlow(graph, v1,v5, capTransformer,edgeFlowMap,edgeFactory);

         alg.evaluate();
         System.out.println("The max flow is: " + alg.getMaxFlow());
         System.out.println(alg.getFlowGraph());
         System.out.println("The edge set is: " + alg.getMinCutEdges().toString());




     }

}
