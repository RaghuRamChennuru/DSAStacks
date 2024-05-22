import java.util.Stack;

public class RedundantBraces
{
    public int braces(String A)
    {
        int n = A.length();

        Stack<Character> stk =  new Stack<>();

        for(int i=0;i<n;i++)
        {
            char c = A.charAt(i);

            int flag = 0;

            if( c == ')')
            {
               while(stk.peek() != '(')
               {
                   stk.pop();
                   flag =1;
               }

               if(flag == 0)
               {
                   return 1;
               }

               stk.pop();
            }
            else if(c == '(' || c== '+' || c == '*' || c== '-' || c == '/')
            {
                stk.push(c);
            }
        }

        return 0;
    }
}
