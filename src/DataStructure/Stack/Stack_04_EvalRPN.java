package DataStructure.Stack;

import java.util.Stack;

/**
 * @Author OliverYu
 * @Date 2019/3/27 23:36
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Stack_04_EvalRPN {
    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     * Valid operators are +,-,*,/. Each operand may be an integer or another expression.

     * Some examples:
     * ["2","1","+","3","*"] -> ((2+1)*3) -> 9
     * ["4","13","5","/","+"] -> (4+(13/5)) -> 6

     * @param values
     * @return
     */
    public static int evalRPN(String[] values) {
        Stack<Integer> stack = new Stack<>();
        String temp = "";
        int a = 0;
        int b = 0;
        for (int i=0; i<values.length; i++) {
            temp = values[i];
            switch (temp) {
                case "+" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                    break;

                case "-" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;

                case "*" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;

                case "/" :
                    a = stack.pop();
                    b = stack.pop();
                    if (a == 0) {
                        return -1;
                    }else {
                        stack.push(b / a);
                    }
                    break;

                default:
                    stack.push(Integer.parseInt(temp));
            }
        }
        int result = stack.peek();
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(strings));
    }
}
