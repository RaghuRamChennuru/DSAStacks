/*
* You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.
*
* */

import java.util.Stack;

public class ConsecutivePairs
{
    public String solve(String A)
    {
        int n = A.length();

        if(n == 1)
        {
            return A;
        }

        Stack<Character> stk = new Stack<>();

        for(int i=0;i<n;i++)
        {
            char c = A.charAt(i);

            if(stk.isEmpty())
            {
                stk.push(c);
            }
            else
            {
                char head  =  (char)stk.peek();

                if(c == head)
                {
                    stk.pop();
                }
                else
                {
                    stk.push(c);
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        while(!stk.isEmpty())
        {
            sb.append(stk.pop().toString());
        }

         return  sb.reverse().toString();
    }
}
