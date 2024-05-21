/*
* Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
* */

import java.util.Stack;

public class TwoBracketExpression
{
    public int solve(String A, String B)
    {
        boolean[] arr = new boolean[26];
        boolean[] brr = new boolean[26];

        evaluate(arr,A);
        evaluate(brr, B);

        for(int i=0;i<26;i++)
        {
            if(arr[i] != brr[i])
            {
                return 0;
            }
        }

        return 1;
    }

    public void evaluate(boolean[] arr,String str)
    {
        int n = str.length();

        Stack<Boolean> stk = new Stack<>();

        stk.push(true);

        for(int i=0;i<n;i++)
        {
            char c = str.charAt(i);

            if(c == '(')
            {
                if(checkSign(str,i)) // No Minus Sign Before ( or i == 0
                {
                    stk.push(stk.peek());
                }
                else // Minus Sign ..so - * - = +  or + * - = - ... so inverse of peek ... if peek = + , then - , else +
                {
                    stk.push(!stk.peek());
                }
            }
            else if(c == ')')
            {
                stk.pop();
            }
            else if(c == '+' || c == '-')
            {

            }
            else
            {
                if(stk.peek()) // Positive + on Top Of Stack
                {
                    // Check any Sign is There beside the operand

                    if(checkSign(str,i)) // Positive
                    {
                        arr[c - 'a'] = true;
                    }
                    else // Not Available
                    {
                        arr[c - 'a'] = false;
                    }

                }
                else // Negative On Top Of Stack
                {
                    // Check any Sign is There beside the operand

                    if(checkSign(str,i)) // Positive
                    {
                        arr[c - 'a'] = false;
                    }
                    else // Not Available
                    {
                        arr[c - 'a'] = true;
                    }
                }
            }
        }
    }

    public boolean checkSign(String exp,int i) // String and index
    {
        if(i == 0)
        {
            return true;
        }

        char c = exp.charAt(i-1);

        if(c == '-')  // if ( has - before it , it means it is a false;
        {
            return false;
        }

        return true;
    }
}
