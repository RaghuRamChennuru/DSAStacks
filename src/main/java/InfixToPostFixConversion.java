import java.util.HashMap;
import java.util.Stack;

public class InfixToPostFixConversion
{
    public static void main(String args[])
    {
        String a = "q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)";

        a = solve(a);

        System.out.println(a);

    }
    public static  String solve(String A)
    {
        int n = A.length();

        if(n == 1)
        {
            return A;
        }

        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('(',6);
        hm.put('^',5);
        hm.put('/',4);
        hm.put('*',4);
        hm.put('+',3);
        hm.put('-',3);

        Stack<Character> stk = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++)
        {
            char c = A.charAt(i);

            if(c == '(' || c == ')' || c == '^' || c == '/' || c== '*' || c== '+' || c == '-')
            {
                if(stk.isEmpty() || c == '(')
                {
                    stk.push(c);
                }
                else if(c == ')')
                {
                    while(stk.peek() != '(')
                    {
                        sb.append(stk.pop());
                    }

                    stk.pop();

                }
                else
                {
                    int curr  = hm.get(c);
                    int top  = hm.get(stk.peek());

                    if(curr > top)
                    {
                        stk.push(c);
                    }
                    else // Input is less than top...pop till we get greater
                    {
                        while(!stk.isEmpty() && curr <= top && stk.peek() != '(' )
                        {
                            sb.append(stk.pop());

                            if(!stk.isEmpty())
                                top = hm.get(stk.peek());
                        }

                        stk.push(c);
                    }
                }
            }
            else
            {
                sb.append(c);
            }
        }

        while(!stk.isEmpty())
        {
            sb.append(stk.pop());
        }

        return sb.toString();

    }
}
