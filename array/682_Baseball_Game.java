import java.util.Stack;

class Solution {

    public int calPoints(String[] operations) {
        Stack<Integer> records = new Stack<>();

        for (var operation : operations) {
            switch (operation) {
                case "+":
                    int top1 = records.pop();
                    int sumOfTwoElement = top1 + records.peek();

                    records.push(top1);
                    records.push(sumOfTwoElement);
                    break;
                case "D":
                    records.push(records.peek() * 2);
                    break;
                case "C":
                    records.pop();
                    break;
                default:
                    records.push(Integer.valueOf(operation));
            }
        }

        int result = 0;

        while (!records.empty()) {
            result += records.pop();
        }

        return result;
    }
}
