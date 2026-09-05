
// 682. Baseball Game

// Using Stack
class BaseBall682 {
    public int calPoints(String[] operations) {
        Stack<Integer> recData = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];

            if (op.equals("C")) {
                recData.pop();
            } else if (op.equals("D")) {
                recData.push(recData.peek() * 2);
            } else if (op.equals("+")) {
                int prev = recData.pop();
                int newScore = prev + recData.peek();
                recData.push(prev);
                recData.push(newScore);
            } else {
                recData.push(Integer.parseInt(op));
            }
        }

        int answer = 0;
        while (!recData.isEmpty()) {
            answer += recData.pop();
        }
        return answer;
    }
}

// By Using ArrayList

class BaseBall682 {
    public int calPoints(String[] operations) {
        ArrayList<Integer> recData = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];

            if (op.equals("C")) {
                recData.remove(recData.size()-1);

            } else if (op.equals("D")) {

                recData.add(recData.get(recData.size()-1) * 2);
            } else if (op.equals("+")) {

                recData.add(recData.get(recData.size()-2)+ recData.get(recData.size()-1));
            } else {
                recData.add(Integer.parseInt(op));
            }
        }

        int answer = 0;
        while (!recData.isEmpty()) {
            answer += recData.remove(recData.size()-1);
        }
        return answer;
    }
}