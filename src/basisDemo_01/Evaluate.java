package basisDemo_01;

import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;
import java.util.Stack;

/**
 * 双栈算术表达式求值算法
 * 输入一行表达式字符串：(1+((2+3)*(4*5)))
 * 输入出表达式结果
 */
public class Evaluate {
    public static void main(String[] args) {
        //存放字符串操作数的栈
        Stack<Double> nums = new Stack<>();
        //存放字符串操作符的栈
        Stack<String> ops = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        //输入的表达式字符串
        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); i++) {
            //遍历字符串读取每个字符
            String s = str.substring(i, i + 1);
            switch (s) {
                case "(": //不做操作
                    break;
                case "+":
                case "-":
                case "*":
                case "/": //加入操作符数组
                    ops.push(s);
                    break;
                case ")": //遇到 ")"取出两个操作数和操作符计算，再将结果放入操作数数组
                    String op = ops.pop();
                    double num = nums.pop();
                    switch (op) {
                        case "+":
                            num += nums.pop();
                            break;
                        case "-":
                            num -= nums.pop();
                            break;
                        case "*":
                            num *= nums.pop();
                            break;
                        case "/":
                            num /= nums.pop();
                            break;
                    }
                    nums.push(num);
                    break;
                default:
                    nums.push(Double.parseDouble(s));
            }
        }
        System.out.println(nums.pop());
    }

}
