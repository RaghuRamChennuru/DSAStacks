/*
* Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.
* */


import java.util.ArrayList;
import java.util.Stack;

public class Sortstackusinganotherstack
{
    public ArrayList<Integer> solve(ArrayList<Integer> A)
    {
        int n = A.size();

        if(n == 1)
        {
            return A;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> orgstk =new Stack<>();

        for(int i=0;i<n;i++)
        {
            orgstk.push(A.get(i));
        }


        Stack<Integer> dup = new Stack<>();

        while(!orgstk.isEmpty())
        {
            int value = orgstk.pop();

            while(!dup.isEmpty() && value > dup.peek()) // pop out till dup has smaller than value
            {
                orgstk.push(dup.pop());
            }

            dup.push(value);

        }

        while(!dup.isEmpty())
        {
            arr.add(dup.pop());
        }

        return arr;
    }
}
