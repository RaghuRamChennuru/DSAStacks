import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement
{
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A)
    {
        int n = A.size();

        if(n == 1)
        {
            return new ArrayList<>(A.get(0));
        }

        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<n;i++)
        {

            while(!stk.isEmpty() && A.get(i) <= stk.peek())
            {
                stk.pop();
            }

            if(stk.isEmpty())
            {
                arr.add(-1);
                stk.push(-1);
            }
            else
            {
                arr.add(stk.peek());
                stk.push(A.get(i));
            }
        }

        return arr;

    }
}
