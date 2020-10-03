package dijkstra.graph;

import java.util.ArrayList;
import java.util.Collection;

public class Graph {
  ArrayList<Node> nodes = new ArrayList<>();

  public void addNode(Node node) {
    this.nodes.add(node);
  }

  public void addAllNodes(Collection<Node> nodesToAdd) {
    this.nodes.addAll(nodesToAdd);
  }

  public ArrayList<Node> getNodes() {
    return nodes;
  }

  public void setNodes(ArrayList<Node> nodes) {
    this.nodes = nodes;
  }
}
