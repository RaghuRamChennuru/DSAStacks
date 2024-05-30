/*
* Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.

Find the largest rectangle containing only 1's and return its area
* */

import java.util.*;

public class MaximumRectangle
{
    public int solve(ArrayList<ArrayList<Integer>> A)
    {
        int n = A.size();
        int m = A.get(0).size();

        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i == 0)
                {
                    arr[i][j] = A.get(i).get(j);
                }
                else
                {
                    if(A.get(i).get(j) == 0)
                    {
                        arr[i][j] = 0;
                    }
                    else
                    {
                        arr[i][j] = arr[i-1][j] + A.get(i).get(j);
                    }

                }
            }
        }

        int maxvalue  = Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            int value = largestRectangleArea(arr[i]);

            maxvalue = Math.max(maxvalue,value);
        }

        return maxvalue;
    }

    public int largestRectangleArea(int[] A)
    {
        int n = A.length;

        if(n == 1)
        {
            return A[0];
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stk = new Stack<>();

        // Calculating left nearest element

        for(int i=0;i<n;i++)
        {
            while(!stk.isEmpty() && A[stk.peek()] >= A[i])
            {
                stk.pop();
            }

            if(stk.isEmpty())
            {
                left[i] = -1;
            }
            else
            {
                left[i] = stk.peek();
            }

            stk.push(i);

        }

        stk.clear();
        // Calculating right nearest element

        for(int i=n-1;i>=0;i--)
        {
            while(!stk.isEmpty() && A[stk.peek()] >= A[i])
            {
                stk.pop();
            }

            if(stk.isEmpty())
            {
                right[i] = n; // From right side , it is n index to right *******
            }
            else
            {
                right[i] = stk.peek();
            }

            stk.push(i);

        }


        // For each bar calculate distance to left and right

        int maxsum = Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {

            //System.out.println("Left : "+left[i] + ", Right : "+right[i]);

            //b-a+1

            int bars = right[i] - left[i] - 1;

            // multiply with bar height

            maxsum = Math.max(maxsum,bars * A[i]);
        }

        return maxsum;
    }
}
