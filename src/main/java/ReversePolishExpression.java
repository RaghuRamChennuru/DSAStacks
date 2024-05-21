/*
* An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
* */

import java.util.ArrayList;
import java.util.Stack;

public class ReversePolishExpression
{
    public int evalRPN(ArrayList<String> A)
    {
        int n = A.size();

        if(n == 1)
        {
            return Integer.parseInt(A.get(0));
        }
        else
        {
            Stack<Integer> stk = new Stack<Integer>();

            for(int i=0;i<n;i++)
            {
                String c  = A.get(i);

                if(c.equalsIgnoreCase("*") || c.equalsIgnoreCase("/") ||
                        c.equalsIgnoreCase("+") || c.equalsIgnoreCase("-") )
                {
                    int a = stk.pop();
                    int b = stk.pop();
                    int cal = 1;

                    if(c.equalsIgnoreCase("*"))
                    {
                        cal = a*b;
                    }
                    else if(c.equalsIgnoreCase("/"))
                    {
                        cal = b/a;
                    }
                    else if(c.equalsIgnoreCase("+"))
                    {
                        cal = a+b;
                    }
                    else if(c.equalsIgnoreCase("-"))
                    {
                        cal  = b - a;
                    }

                    stk.push(cal);
                }
                else
                {
                    int value  = Integer.parseInt(A.get(i));

                    stk.push(value);
                }
            }

            return stk.peek();
        }
    }
}
