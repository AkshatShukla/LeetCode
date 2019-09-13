import java.util.*;

public class InsertDeleteGetRandom {
    List<Integer> list;
    Map<Integer, Integer> valToInd;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        // list stores current keys of the map
        list = new ArrayList<>();
        // map with element and index of list as key and value
        valToInd = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToInd.containsKey(val)) {
            return false;
        }
        valToInd.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToInd.containsKey(val)) {
            return false;
        }

        int indexToRemove = valToInd.get(val);
        int valueLast = list.get(list.size() - 1);

        // update list
        list.set(indexToRemove, valueLast);
        list.remove(list.size() - 1);

        // update map
        valToInd.put(valueLast, indexToRemove);
        valToInd.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
