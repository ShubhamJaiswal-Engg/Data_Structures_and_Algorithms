


class FindMediFromDataStr295 {
    private PriorityQueue<Integer> leftMax;   
    private PriorityQueue<Integer> rightMin;  

    public FindMediFromDataStr295() {
        leftMax = new PriorityQueue<>(Collections.reverseOrder());
        rightMin = new PriorityQueue<>();
    }

    public void addNum(int num) {
        leftMax.add(num);
        rightMin.add(leftMax.poll());          
        if (rightMin.size() > leftMax.size()) {
            leftMax.add(rightMin.poll());
        }
    }

    public double findMedian() {
        if (leftMax.size() == rightMin.size()) {
            return ((long) leftMax.peek() + rightMin.peek()) / 2.0;
        }
        return leftMax.peek();
    }
}