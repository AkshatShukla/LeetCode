import java.util.PriorityQueue;

public class MinCostToConnectRopes {
    public static int minCostToConnect(int[] ropes) {
        int minCost = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int ropeLen : ropes) {
            priorityQueue.offer(ropeLen);
        }

        while (!priorityQueue.isEmpty()) {
            int rope1 = priorityQueue.poll();
            if (priorityQueue.peek() == null) {
                return minCost;
            }
            int rope2 = priorityQueue.poll();
            minCost += rope1 + rope2;
            priorityQueue.offer(rope1 + rope2);
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[] ropes = new int[]{8, 4, 6, 12}; // 58
        int[] ropes1 = new int[]{1,2,5,10,35,89}; // 224
        int[] ropes2 = new int[]{2,2,3,3}; // 20
        int[] ropes3 = new int[]{20,4,8,2}; // 54
        System.out.println(minCostToConnect(ropes));
        System.out.println(minCostToConnect(ropes1));
        System.out.println(minCostToConnect(ropes2));
        System.out.println(minCostToConnect(ropes3));
    }
}
