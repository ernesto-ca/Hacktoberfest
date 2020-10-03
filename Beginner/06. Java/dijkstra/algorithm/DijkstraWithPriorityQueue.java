package dijkstra.algorithm;

import dijkstra.graph.Edge;
import dijkstra.graph.Graph;
import dijkstra.graph.Node;
import java.util.PriorityQueue;

public class DijkstraWithPriorityQueue implements Dijkstra {

  Graph graph;

  public DijkstraWithPriorityQueue(Graph graph) {
    this.graph = graph;
  }

  @Override
  public Graph dijkstra(Node start) {
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    for(Node n : graph.getNodes()) {
      n.setDistance(Integer.MAX_VALUE);
      n.setSeen(false);
      n.setPrevious(null);
    }

    start.setDistance(0);
    priorityQueue.add(start);

    while(!priorityQueue.isEmpty()) {
      Node best = priorityQueue.remove();

      best.setSeen(true);

      for(Edge edge : best.getEdges()) {
        if(best.getDistance() + edge.getWeight() < edge.getDestination().getDistance()) {
          edge.getDestination().setDistance(best.getDistance() + edge.getWeight());
          edge.getDestination().setPrevious(best);

          if(!edge.getDestination().getSeen()) {
            priorityQueue.add(edge.getDestination());
          }
        }
      }
    }

    return graph;
  }
}
