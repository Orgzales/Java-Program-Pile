public class Sequencer {


    public Sequencer()
    {

    }

    public static long fibRecursive(int num)
    {
        if (num == 0)
            return 0;
        else if ( num == 1)
            return 1;
        else
        {
            return ( fibRecursive(num - 1) + fibRecursive( num - 2) );
        }

    }

    public static long fibIterative(int num)
    {
        int previous_1 = 1;
        int previous_2 = 0;
        int results = 0;

        for ( int x = 1; x <= num; x++)
        {
            results = previous_1 + previous_2;
            previous_1 = previous_2;
            previous_2 = results;
        }
        return results;
    }

    public static long sumIterative(int num)
    {
        long results = 0;

        for(int x = 1; x <= num; x++)
        {
            results += x;
        }

        return results;
    }

    public static long sumGauss(long num)
    {
        return ( (num * (num + 1)) / 2);
    }


}
