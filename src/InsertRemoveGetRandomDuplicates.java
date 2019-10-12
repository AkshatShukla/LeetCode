import java.util.*;

public class InsertRemoveGetRandomDuplicates {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand;
    /** Initialize your data structure here. */
    public InsertRemoveGetRandomDuplicates() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        int indexToRemove = map.get(val).iterator().next();
        map.get(val).remove(indexToRemove);
        int lastElement = list.get(list.size() - 1);
        // swap last element and element to remove
        list.set(indexToRemove, lastElement);

        // update map as well
        map.get(lastElement).add(indexToRemove);
        map.get(lastElement).remove(list.size() - 1);
        // remove the last element from the list as we already copied it
        // to replace the element to remove
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
