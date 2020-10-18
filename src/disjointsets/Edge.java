package disjointsets;

public class Edge {

    Vertex to;
    Vertex from;
    int weight;

    public Edge(Vertex to, Vertex from) {
        new Edge(to, from, 0);
    }

    public Edge(Vertex to, Vertex from, int weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    public int compareTo(Edge other) {
        if (this.weight > other.getWeight()) {
            return 1;
        }
        if(this.weight < other.getWeight()) {
            return -1;
        }
        return 0;
    }
}
