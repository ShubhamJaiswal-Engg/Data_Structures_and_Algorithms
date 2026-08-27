// 658. Find K Closest Elements

// Space complexity -> O(n)
class KNearestElement658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int integer : arr) {
            if(k > 0) {
                minHeap.offer(integer);
                k--;
            } else if(Math.abs((minHeap.peek() - x)) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.add(integer);
            }
        }
        List<Integer> result = new ArrayList<>();
        int n = minHeap.size();
        for(int i = 0; i < n; i++) {
            result.add(minHeap.poll());
        };
        return result;
    }
}

// Optimize Solution 
// Space complexity -> O(1)

class KNearestElement658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;

        while (r - l >= k) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                r--;
            } else {
                l++;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}