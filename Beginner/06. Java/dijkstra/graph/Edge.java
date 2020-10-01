package dijkstra.graph;

public class Edge implements Comparable<Edge> {
  Node destination;
  Integer weight;

  public Edge(Node destination, int weight) {
    this.destination = destination;
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge o) {
    return weight.compareTo(o.weight);
  }

  public Node getDestination() {
    return destination;
  }

  public void setDestination(Node destination) {
    this.destination = destination;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }
}
