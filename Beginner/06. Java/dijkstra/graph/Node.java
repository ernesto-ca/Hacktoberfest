package dijkstra.graph;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Node implements Comparable<Node> {

  Integer distance = Integer.MAX_VALUE;
  Boolean seen = false;
  Node previous = null;
  LinkedHashSet<Edge> edges = new LinkedHashSet<>();
  String name;


  public Node(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Node o) {
    return this.distance.compareTo(o.distance);
  }

  @Override
  public int hashCode() {
    return name.hashCode() + distance.hashCode() + seen.hashCode() + previous.hashCode();
  }

  public void addEdge(Edge edge) {
    edges.add(edge);
  }

  public void addAllEdges(Collection<Edge> edge) {
    edges.addAll(edge);
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public Boolean getSeen() {
    return seen;
  }

  public void setSeen(Boolean seen) {
    this.seen = seen;
  }

  public Node getPrevious() {
    return previous;
  }

  public void setPrevious(Node previous) {
    this.previous = previous;
  }

  public LinkedHashSet<Edge> getEdges() {
    return edges;
  }

  public void setEdges(LinkedHashSet<Edge> edges) {
    this.edges = edges;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
