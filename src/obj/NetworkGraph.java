package obj;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;

public class NetworkGraph{

    Graph<Integer, DefaultEdge> graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class); //GRAPH

    public NetworkGraph(ArrayList<Node> ret) {

        Node currentNode;
        int currentNeighborID;

        for (int i = 0; i < ret.size(); i++) { //Add vertices
            currentNode = ret.get(i);
            graph.addVertex(currentNode.getNode_id());
        }
        for (int i = 0; i < ret.size(); i++) { //Add edges
            currentNode = ret.get(i);
            for (int j = 0; j < ret.get(i).getVoisins().size(); j++) {
                currentNeighborID = currentNode.getVoisins().get(j);
                graph.addEdge(currentNode.getNode_id(), currentNeighborID);
            }
        }
    }

    public Graph<Integer, DefaultEdge> getGraph() {
        return graph;
    }
}