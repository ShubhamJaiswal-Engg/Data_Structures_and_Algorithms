import java.util.*;
public class ReverseFirstK {
    public static void reverseKelement(Queue<Integer> q, int k) {
        Deque<Integer> qu = new LinkedList<>();

        for(int i = 0; i < k; i++) {
            qu.addFirst(q.remove());
        };
        while(!q.isEmpty()) {
            qu.add(q.remove());
        };
         while(!qu.isEmpty()) {
            System.out.print(qu.remove() +" ");
        };
    };
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);

        // System.out.println(q.get(2));
        reverseKelement(q, 4);
    };
};
// import java.util.*;
// public class ReverseFirstK {
//     public static void reverseKelement(Queue<Integer> q, int k) {
//         Queue<Integer> qu = new LinkedList<>();
//         Stack<Integer> st = new Stack<>();
//         for(int i = 0; i < k; i++) {
//             st.push(q.remove());
//         };
//         while(!st.isEmpty()) {
//             qu.add(st.pop());
//         };
//         while(!q.isEmpty()) {
//             qu.add(q.remove());
//         };
//          while(!qu.isEmpty()) {
//             System.out.print(qu.remove() +" ");
//         };
//     };
//     public static void main(String args[]) {
//         Queue<Integer> q = new LinkedList<>();
//         q.add(10);
//         q.add(20);
//         q.add(30);
//         q.add(40);
//         q.add(50);
//         q.add(60);
//         q.add(70);
//         q.add(80);
//         q.add(90);
//         q.add(100);

//         // System.out.println(q.get(2));
//         reverseKelement(q, 4);
//     };
// };
