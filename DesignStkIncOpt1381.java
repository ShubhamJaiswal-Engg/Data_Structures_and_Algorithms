


class DesignStkIncOpt1381 {
    int maxSizelimit;
    int currSize;
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public CustomStack(int maxSize) {
        currSize = 0;
        maxSizelimit = maxSize;
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    };
    
    public void push(int x) {
        if(currSize < maxSizelimit) {
            stk1.push(x);
            currSize++;
        }
    }
    
    public int pop() {
        if(currSize == 0) {
            return -1;
        }
        currSize--;
        return stk1.pop();
    }
    
    public void increment(int k, int val) {
        while(!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        
        while(!stk2.isEmpty() && (k > 0)) {
            stk1.push(val + stk2.pop());
            k--;
        }
        while(!stk2.isEmpty()) {
            stk1.push(stk2.pop());
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */