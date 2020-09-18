package com.example.calculator;


import java.util.Stack;

public class Calculate {
    private int i = 0;

    enum Operate {
        ADD, SUB, MUL, DIV, POW, FAC, L_P, R_P, EOE;
        static char pri[][] = { { '>', '>', '<', '<', '<', '<', '<', '>', '>' }, { '>', '>', '<', '<', '<', '<', '<', '>', '>' },
                { '>', '>', '>', '>', '<', '<', '<', '>', '>' }, { '>', '>', '>', '>', '<', '<', '<', '>', '>' },
                { '>', '>', '>', '>', '>', '<', '<', '>', '>' }, { '>', '>', '>', '>', '>', '>', ' ', '<', '>' },
                { '<', '<', '<', '<', '<', '<', '<', '=', ' ' }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                { '<', '<', '<', '<', '<', '<', '<', ' ', '=' }, };
    }

    /*public static void main(String[] args) {
        String s = "1.2+3.6*(2^(1+1)+0.6)\0";
        Calculate c = new Calculate();
        StringBuilder RPN = new StringBuilder();
        float temp = c.calculate(s, RPN);
        System.out.println(temp);

    }*/

    public float calculate(String str, StringBuilder RPN) {
// 新建两个栈，一个存储数据，一个存储操作符
        str=str+"\0";
        Stack<Float> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        char[] oper2 = str.toCharArray();
        operStack.push('\0');
        while (!operStack.isEmpty()) {
            if (isDigit(str)) {
                readNumble(str, numStack);
                RPN.append(numStack.peek());
            } else {
                switch (orderBetween(operStack.peek(), oper2[i])) {
                    case '<':
                        operStack.push(oper2[i]);
                        i++;
                        break;
                    case '=':
                        operStack.pop();
                        i++;
                        break;
                    case '>':
                        char temp = operStack.pop();
                        RPN.append(temp);
                        if (temp == '!') {
                            float opNumber = numStack.pop();
                            numStack.push(calcu(opNumber, temp));
                        } else {
                            float opNumber1 = numStack.pop();
                            float opNumber2 = numStack.pop();
                            numStack.push(calcu(opNumber1, opNumber2, temp));
                        }

                        break;
                    default:
                        throw new RuntimeException("输入字符有误");

                }

            }
        }
        return numStack.pop();
    }

    public boolean isDigit(String str) {
        char[] oper = str.toCharArray();
        if (oper[i] == '0' || oper[i] == '1' || oper[i] == '2' || oper[i] == '3' || oper[i] == '4' || oper[i] == '5'
                || oper[i] == '6' || oper[i] == '7' || oper[i] == '8' || oper[i] == '9') {
            return true;
        } else {
            return false;
        }
    }

    public void readNumble(String str1, Stack<Float> stack) {
        char[] oper1 = str1.toCharArray();
        stack.push((float) oper1[i] - '0');
        i++;
        while (isDigit(str1)) {
            stack.push((float) stack.pop() * 10 + (float) oper1[i] - '0');
            i++;
        }
        if ('.' != (oper1[i])) {
            return;
        } else {
            i++;
            float flaction = 1;
            while (isDigit(str1)) {
                stack.push(stack.pop() + (float) (oper1[i] - '0') * (flaction /= 10));
                i++;
            }
        }
    }

    public char orderBetween(char c1, char c2) {
        return Operate.pri[transfer(c1)][transfer(c2)];
    }

    public int transfer(char c) {
        switch (c) {
            case '+':
                return 0;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            case '^':
                return 4;
            case '!':
                return 5;
            case '(':
                return 6;
            case ')':
                return 7;
            case '\0':
                return 8;
            default:
                throw new RuntimeException("数字输入错误");
        }
    }

    public float calcu(float f1, char temp) {
        if (f1 == 0) {
            return 1;
        } else {
            float data = 1;
            for (float m = 1; m <= f1; m++) {
                data *= m;

            }
            return data;
        }
    }

    public float calcu(float f1, float f2, char temp) {
        switch(temp) {
            case '+':
                return f1+f2;
            case '-':
                return f2-f1;
            case '*':
                return f2*f1;
            case '/':
                return f2/f1;
            case '^':
                return (float) Math.pow(f2, f1);
            default:
                throw new RuntimeException("输入错误");

        }
    }
}



