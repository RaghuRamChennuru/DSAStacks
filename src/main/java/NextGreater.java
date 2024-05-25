/*
* Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.

More formally:

G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.
*
* */

import java.util.*;

public class NextGreater
{
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A)
    {
        int n = A.size();

        ArrayList<Integer> arr = new ArrayList<>();

        if(n == 1)
        {
            arr.add(-1);

            return arr;
        }

        Stack<Integer> stk = new Stack<>();


        for(int i=n-1;i>=0;i--)
        {
            while(!stk.isEmpty() && A.get(i)>stk.peek())
            {
                stk.pop();
            }

            if(stk.isEmpty())
            {
                arr.add(-1);
            }
            else
            {
                arr.add(stk.peek());
            }

            stk.push(A.get(i));
        }

        Collections.reverse(arr);

        return arr;
    }
}
