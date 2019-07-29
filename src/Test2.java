import java.util.*;

public class Test2 {
    public static int[] Solution(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i <= k; i++) {
            minHeap.offer(arr[i]);
        }
        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(minHeap);
            arr[i - (k + 1)] = minHeap.poll();
            minHeap.offer(arr[i]);
        }
        for (int i = 0; i <= k; i++) {
            arr[arr.length - k - 1 + i] = minHeap.poll();
        }
        return arr;
    }

    // The following method get the manhatten distance betwen two points (x1,y1) and (x2,y2)
    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());

        // make a priorityQueue for each user with closest event
        // every element is eventID, list(prices)
        // top of the priorityQueue is the event which is closest
        // simply poll the event for each user and print the event and least price
        // if list)prices for any event is empty, pop that event from priorityQueue

        Map<Integer, int[]> eventWithCoordinates = new HashMap<>();
        Map<Integer, List<Integer>> eventWithCheapestPrices = new HashMap<>();
        while (numberOfEvents > 0) {
            String eventLine = scan.nextLine();
            // TODO: you will need to parse and store the events
            // eventID, x, y, price1, price2 ...
            String[] eventComponents = eventLine.split(" ");
            int eventId = Integer.parseInt(eventComponents[0]);
            int eventXCoord = Integer.parseInt(eventComponents[1]);
            int eventYCoord = Integer.parseInt(eventComponents[2]);
            List<Integer> eventTicketPrices = new ArrayList<>();
            for (int i = 3; i < eventComponents.length; i++) {
                eventTicketPrices.add(Integer.parseInt(eventComponents[i]));
            }
            eventWithCheapestPrices.put(eventId, eventTicketPrices);
            eventWithCoordinates.put(eventId, new int[]{eventXCoord, eventYCoord});
            numberOfEvents--;
        }

        Map<Integer, int[]> buyersWithCoordinates = new HashMap<>();

        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        int buyerId = 1;

        while (numberOfBuyers > 0) {
            String buyerLine = scan.nextLine();
            // TODO: you will need to parse and store the buyers
            // locX, locY
            String[] buyerComponents = buyerLine.split(" ");
            int buyerX = Integer.parseInt(buyerComponents[0]);
            int buyerY = Integer.parseInt(buyerComponents[1]);
            buyersWithCoordinates.put(buyerId, new int[]{buyerX, buyerY});
            buyerId++;
            numberOfBuyers--;
        }

        List<PriorityQueue<Integer>> closestEventToBuyer = new ArrayList<>();
        // for every buyer, print out what getEventsClosest to him
        for (Map.Entry entry : buyersWithCoordinates.entrySet()) {
            PriorityQueue<Integer> closestEvents = new PriorityQueue<>();

            int id = (int) entry.getKey();
            int[] buyerCoordinates = (int[]) entry.getValue();
            closestEvents = findClosestEvent(buyerCoordinates, eventWithCoordinates);
            closestEventToBuyer.add(closestEvents);
        }

        System.out.println(closestEventToBuyer);

        for (PriorityQueue<Integer> buyer : closestEventToBuyer) {
            Integer eventId = null;
            List<Integer> ticketPrices = new ArrayList<>();
            while (ticketPrices.isEmpty()) {
                eventId = buyer.peek();
                if (eventId != null) {
                    ticketPrices = eventWithCheapestPrices.get(eventId);
                    if (ticketPrices.isEmpty()) {
                        buyer.poll();
                    }
                }

            }
            int minPricedTicket = Collections.min(ticketPrices);
            ticketPrices.remove((Integer) minPricedTicket);
            eventWithCheapestPrices.put(eventId, ticketPrices);
            System.out.println(eventId + " " + minPricedTicket);
        }
        // The solution to the first sample above would be to output the following to console:
        // (Obviously, your solution will need to figure out the output and not just hard code it)
//        System.out.println("2 50");
    }

    private static PriorityQueue<Integer> findClosestEvent(int[] buyerCoordinates, Map<Integer, int[]> eventWithCoordinates) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> distance(e, buyerCoordinates, eventWithCoordinates)));
        for (Map.Entry entry : eventWithCoordinates.entrySet()) {
            minHeap.offer((int) entry.getKey());
        }
        return minHeap;
    }

    private static int distance(Integer eventId, int[] buyerCoordinates, Map<Integer, int[]> eventWithCoordinates) {
        int[] eventLocation = eventWithCoordinates.get(eventId);
        return calculateManhattanDistance(buyerCoordinates[0], buyerCoordinates[1], eventLocation[0], eventLocation[1]);
    }
}
