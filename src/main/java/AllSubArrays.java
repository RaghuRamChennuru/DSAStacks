/*
* Given an integer array A of size N. You have to generate it's all subarrays having a size greater than 1.

Then for each subarray, find Bitwise XOR of its maximum and second maximum element.

Find and return the maximum value of XOR among all subarrays.
* */

import java.util.*;

public class AllSubArrays
{
    public int solve(ArrayList<Integer> A)
    {
        int n = A.size();

        if(n == 2)
        {
            return A.get(0)^A.get(1);
        }

        Stack<Integer> stk = new Stack<>();
        stk.push(A.get(0));

        int maxValue = Integer.MIN_VALUE;

        for(int i=1;i<n;i++)
        {
            while(!stk.isEmpty())
            {
                if(stk.peek()<A.get(i))  // Do xor and pop out all the less values..this satisfies as current element as max element in the subarray
                {
                    int value = A.get(i)^stk.pop();
                    maxValue = Math.max(maxValue,value);
                }
                else // Do xor with peek element which satisfies current element as second max
                {
                    int value = A.get(i)^stk.peek();
                    maxValue = Math.max(maxValue,value);
                    break;
                }
            }

            stk.push(A.get(i));
        }

        return maxValue;
    }
}


/*
* In this problem , we create a stack - Monotonous decresing
*
* When a new element comes in , it pop up all the elements on the top till the top is maximum then current
*
* This is to make sure , it becomes second top and the st.top will be maximum
*
*
* */