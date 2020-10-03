package dijkstra.algorithm;

import dijkstra.graph.Edge;
import dijkstra.graph.Graph;
import dijkstra.graph.Node;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraWithoutPriorityQueue implements Dijkstra {

  Graph graph;

  public DijkstraWithoutPriorityQueue(Graph graph) {
    this.graph = graph;
  }

  @Override
  public Graph dijkstra(Node start) {
    ArrayList<Node> settledNodes = new ArrayList<>();
    ArrayList<Node> unsettledNodes = new ArrayList<>();

    for(Node n : graph.getNodes()) {
      n.setDistance(Integer.MAX_VALUE);
      n.setSeen(false);
      n.setPrevious(null);
    }

    start.setDistance(0);
    unsettledNodes.add(start);

    while(!unsettledNodes.isEmpty()) {
      Node best = unsettledNodes.get(0);

      for(Node node : unsettledNodes) {
        if(node.getDistance() < best.getDistance()) {
          best = node;
        }
      }
      unsettledNodes.remove(best);
      best.setSeen(true);

      for(Edge edge : best.getEdges()) {
          if (best.getDistance() + edge.getWeight() < edge.getDestination().getDistance()) {
            edge.getDestination().setDistance(best.getDistance() + edge.getWeight());
            edge.getDestination().setPrevious(best);
            unsettledNodes.add(edge.getDestination());
          }
      }
    }

    return graph;
  }
}
