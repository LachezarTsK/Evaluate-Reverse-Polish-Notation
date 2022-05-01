
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Solution {

    private static Map<String, BiFunction<Integer, Integer, Integer>> operations = initializeMapOperations();

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!operations.containsKey(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int secondOperand = stack.pop();
            int firstOperand = stack.pop();
            stack.push(operations.get(token).apply(firstOperand, secondOperand));
        }
        return stack.pop();
    }

    private static Map<String, BiFunction<Integer, Integer, Integer>> initializeMapOperations() {
        operations = new HashMap<>();
        operations.put("+", (x, y) -> x + y);
        operations.put("-", (x, y) -> x - y);
        operations.put("*", (x, y) -> x * y);
        operations.put("/", (x, y) -> x / y);
        return operations;
    }
}
