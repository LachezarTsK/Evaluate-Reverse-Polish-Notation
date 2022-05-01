
/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function (tokens) {
    const operations = new Map();
    initializeMapOperations(operations);
    const stack = [];
    for (let token of tokens) {
        if (!operations.has(token)) {
            stack.push(Number(token));
            continue;
        }
        let secondOperand = stack.pop();
        let firstOperand = stack.pop();
        stack.push(operations.get(token)(firstOperand, secondOperand));
    }
    return stack.pop();
};

/**
 * @param {Map(key: string, value: function)} operations
 * @return {void}
 */
function initializeMapOperations(operations) {
    operations.set("+", (x, y) => x + y);
    operations.set("-", (x, y) => x - y);
    operations.set("*", (x, y) => x * y);
    operations.set("/", (x, y) => Math.trunc(x / y));
}
