package graphs.minspantrees;

import disjointsets.DisjointSets;
import disjointsets.UnionBySizeCompressingDisjointSets;

import java.util.*;

import graphs.Vertex;
import graphs.Edge;
import graphs.CompatibilityGraph;


//Finds maximum possible matches
public class KruskalsMax {

    public DisjointSets<Vertex> createDisjointSets() {
        return new UnionBySizeCompressingDisjointSets<Vertex>();
    }

    public Set<Edge> maxCompatibility(CompatibilityGraph graph) {
        Set<Edge> finalSet = new HashSet<>();

        DisjointSets<Vertex> disjointSets = createDisjointSets();
        List<Edge> list = new ArrayList<>(graph.getEdges());
        Collections.sort(list);

        for (Vertex v: graph.getVertices()) {
            disjointSets.makeSet(v);
        }

        Set<Vertex> added = new HashSet<>();
        while(finalSet.size() <= graph.getEdges().size() / 2) {
            Edge e = list.remove(list.size() - 1);
            if(!added.contains(e.getTo()) && !added.contains(e.getFrom())) {
                finalSet.add(e);
                added.add(e.getTo());
                added.add(e.getFrom());
            }
        }


        return finalSet;
    }

}
