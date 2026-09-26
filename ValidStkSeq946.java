
// 946. Validate Stack Sequences

class ValidStkSeq946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = popped.length;

        Stack<Integer> st = new Stack<>();

        int pop = 0;
        for(int push = 0; push < n; push++) {
            while(!st.isEmpty() && st.peek() == popped[pop]) {
                st.pop();
                pop++;
            };
            st.push(pushed[push]);
        }
            while(!st.isEmpty() && st.peek() == popped[pop]) {
                st.pop();
                pop++;
            };
        return st.isEmpty() && pop == n;
    }
}


class ValidStkSeq946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int s[] = new int[pushed.length];
        int top = -1;
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            s[++top] = pushed[i];
            while (top >= 0 && j < popped.length && s[top] == popped[j]) {
                top--;
                j++;
            }
        }
        return top == -1;
    }
}