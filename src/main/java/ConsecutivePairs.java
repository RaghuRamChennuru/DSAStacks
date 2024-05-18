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
            sb.append(stk.pop().toString);
        }

         return  sb.reverse().toString();
    }
}
