import java.util.Stack;

public class MinStack
{
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> minstk = new Stack<>();

    MinStack()
    {
        stk.clear();
        minstk.clear();
    }

    public void push(int x)
    {
        stk.push(x);

        if(minstk.isEmpty())
        {
            minstk.push(x);
        }
        else
        {
            int min = minstk.peek();

            if(x < min)
            {
                minstk.push(x);
            }
            else
            {
                minstk.push(min);
            }
        }

    }

    public void pop()
    {
        if(stk.isEmpty())
           return ;

        stk.pop();
        minstk.pop();
    }

    public int top()
    {
        if(stk.isEmpty())
            return -1;

        return stk.peek();
    }

    public int getMin()
    {
        if(minstk.isEmpty())
            return -1;

        return minstk.peek();
    }
}
