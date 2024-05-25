/*
* Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.
* */
import java.util.*;
public class LargestRectangleInHistogram
{
    public static void main(String args[])
    {
        ArrayList<Integer> arr =  new ArrayList<>();
        Collections.addAll(arr,47,69,67,97,86,34,98,16,65,95,66,69,18,1,99,56,35,9,48,72,49,47,1,72,87,52,13,23,95,55,21,92,36,88,48,39,84,16,15,65,7,58,2,21,54,2,71,92,96,100,28,31,24,10,94,5,81,80,43,35,67,33,39,81,69,12,66,87,86,11,49,94,38,44,72,44,18,97,23,11,30,72,51,61,56,41,30,71,12,44,81,43,43,27);

        int ans = largestRectangleArea(arr);

        System.out.println(ans);
    }
    public static int largestRectangleArea(ArrayList<Integer> A)
    {
        int n = A.size();

        if(n == 1)
        {
            return A.get(0);
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stk = new Stack<>();

        // Calculating left nearest element

        for(int i=0;i<n;i++)
        {
            while(!stk.isEmpty() && A.get(stk.peek()) >= A.get(i))
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
            while(!stk.isEmpty() && A.get(stk.peek()) >= A.get(i))
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

            maxsum = Math.max(maxsum,bars * A.get(i));
        }

        return maxsum;
    }
}
