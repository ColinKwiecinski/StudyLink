package graphs;

import graphs.Edge;
import graphs.Vertex;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


//makes a set of edges where vertex is user, edge is compatability
public class CompatibilityGraph {

    Set<Vertex> vertices;
    Set<Edge> edges;

    public CompatibilityGraph(Set<Vertex> vertices) {
        this.vertices = vertices;
        edges = makeEdges();
    }

    public Set<Edge> makeEdges() {
        Set<Edge> result = new HashSet<>();
        for(Vertex v : vertices) {
            int id1 = v.getId();
            Set<Vertex> visited = new HashSet<>();
            visited.add(v);
            for(Vertex w : vertices) {
                if(!visited.contains(w)) {
                    int id2 = w.getId();
                    int weight = getCompatibility(id1, id2);
                    result.add(new Edge(v,w, weight));
                }
            }
        }
        return result;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Set<Vertex> getVertices() {return vertices; }

    private int getCompatibility(int id1, int id2){
        //somehow search up values from sql database and then compare

        return 0;

    }






}
