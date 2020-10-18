package disjointsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A quick-union-by-size data structure with path compression.
 * @see DisjointSets for more documentation.
 */
public class UnionBySizeCompressingDisjointSets<T> implements DisjointSets<T> {
    // Do NOT rename or delete this field. We will be inspecting it directly in our private tests.
    List<Integer> pointers;
    Map<T, Integer> finder;

    /*
    However, feel free to add more fields and private helper methods. You will probably need to
    add one or two more fields in order to successfully implement this class.
    */

    public UnionBySizeCompressingDisjointSets() {
        pointers = new ArrayList<>();
        finder = new HashMap<>();
    }

    @Override
    public void makeSet(T item) {
        finder.put(item, pointers.size());
        pointers.add(-1);
    }

    @Override
    public int findSet(T item) {
        if (!finder.containsKey(item)) {
            throw new IllegalArgumentException();
        }

        List<Integer> visited = new ArrayList<>();
        int index = finder.get(item);

        //Traversing up the tree
        while (pointers.get(index) >= 0) {
            index = pointers.get(index);
            visited.add(index);
        }

        //path compression
        for (int i = 0; i < visited.size() - 1; i++) {
            pointers.set(i, index);
        }
        return index;
    }

    @Override
    public boolean union(T item1, T item2) {
        int root1 = findSet(item1);
        int root2 = findSet(item2);
        int weight1 = -1 * pointers.get(root1);
        int weight2 = -1 * pointers.get(root2);

        if (root1 == root2) {
            return false;
        }

        if (weight1 < weight2) {
            pointers.set(root1, root2);
            pointers.set(root2, -1 * (weight1 + weight2));
        } else {
            pointers.set(root2, root1);
            pointers.set(root1, -1 * (weight1 + weight2));
        }
        return true;
    }
}
