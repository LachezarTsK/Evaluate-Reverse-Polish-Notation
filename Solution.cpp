
#include <unordered_map>
#include <iterator>
#include <string>
#include <deque>
using namespace std;

class Solution {

	inline static unordered_map<string, function<int(int, int)>> operations{
		{"+", [](int x, int y) {return x + y; }},
		{"-", [](int x, int y) {return x - y; }},
		{"*", [](int x, int y) {return x * y; }},
		{"/", [](int x, int y) {return x / y; }}
	};
	
public:
	int evalRPN(vector<string>& tokens) {
		deque<int> stack;
		for (const auto& token : tokens) {
			if (operations.find(token)== operations.end()) {
				stack.push_back(stoi(token));
				continue;
			}
			int secondOperand = stack.back();
			stack.pop_back();
			int firstOperand = stack.back();
			stack.pop_back();
			stack.push_back(operations[token](firstOperand, secondOperand));
		}
		return stack.back();
	}
};
