/*
* Given an expression string A, examine whether the pairs and the orders of
* “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
* */
import java.util.*;
public class BalancedParanthesis
{
    public int solve(String A)
    {
        int n = A.length();

        if(n == 1)
        {
            return 0;
        }

        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++)
        {
            char c = (char)A.charAt(i);

            if(st.isEmpty())
            {
                if(c == '}' || c == ']' || c == ')')
                {
                    return 0;
                }

                st.push(c);
            }
            else
            {
                if(c == '}' || c == ']' || c == ')')
                {
                    char head = st.peek();

                    if(c ==  '}' && head == '{')
                    {
                        st.pop();
                    }
                    else if(c == ']' && head == '[')
                    {
                        st.pop();
                    }
                    else if(c == ')' && head == '(')
                    {
                        st.pop();
                    }
                    else
                    {
                        return 0;
                    }
                }
                else
                {
                    st.push(c);
                }
            }

        }

        if(st.isEmpty())
        {
            return 1;
        }

        return 0;

    }
}
