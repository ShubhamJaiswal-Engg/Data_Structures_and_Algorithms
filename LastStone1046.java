// 1046. Last Stone Weight

class LastStone1046 {
    public int lastStoneWeight(int[] stones) {

        // You can use here lamda function (a, b) -> Integer.compare(b - a) alse

        // Max heap 
        // Without reverse it will Min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        while(pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if (x != y) {
                pq.offer(y-x);
            }
        };
        return  pq.isEmpty() ? 0 : pq.peek();
    };
};