import java.math.*;

public class Sequence
{
    private int mMin = 0;
    private int mMax = 0;

    public Sequence(int min, int max)
    {
        //TODO: assign the arguments to the class member variables
        mMin = min;
        mMax = max;
    }

    public int[] list()
    {
        //TODO: return array of the consecutive integers between the bounds (inclusive)
        // i.e. the first number is the min bound and the last number is the max bound

        int spot = mMin;
        int[] arry = new int[mMax - mMin +1];

        for(int x = 0; x < arry.length; x++)
        {
            arry[x] = spot;
            spot++;

        }

        return arry;
    }

    public int[] backwards()
    {
        //TODO: return array of the consecutive integers between bounds in descending order
        // i.e. the first number is the max bound and the last number is the min bound
        int spot = mMax;
        int[] arry = new int[mMax - mMin +1];


        for(int x = 0; x < arry.length; x++)
        {
            arry[x] = spot;
            spot--;

        }

        return arry;
    }

    public int[] evens()
    {
        //TODO: return array of only even integers in the sequence
        // the array should be the exact correct size containing only the even numbers
        int spot = mMin;
        int[] arry = new int[(int) Math.ceil((mMax - mMin +1 ) /2)];
        for(int x = 0; x < arry.length; x++)
        {
            if(spot % 2 ==0)
            {
                arry[x] = spot;

            }
            else
            {
                x--;
            }
            spot++;
        }

        return arry;
    }

    public int[] squares()
    {
        //TODO: return array of sequence integers squared
        // i.e. square each integer in the sequence
        int spot = mMin;
        int[] arry = new int[mMax - mMin +1];

        for(int x = 0; x < arry.length; x++)
        {
            int i = (int) Math.pow(spot,2);
            arry[x] = i;
            spot++;
        }

        return arry;
    }

    public int summation()
    {
        //TODO: return the summation of the sequence
        // i.e. add all the sequence integers together and return the result
        int spot = mMin;
        int[] arry = new int[mMax - mMin +1];
        int total = 0;

        for(int x = 0; x < arry.length; x++)
        {
            total = total + spot;
            spot++;

        }

        return total;
    }
}
