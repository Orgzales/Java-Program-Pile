import java.util.Random;
import java.util.Scanner;

public class Main
{

    private static int load = 0;
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Random prng = new Random();
        double[] arry;

        catchcall();

        arry = new double[load];

        for(int x = 0; x < load; x++)
        {
            double rand = Math.abs(prng.nextDouble() * 100.0);
            arry[x] = rand;
        }

        spacer();
        printSales(arry);
        spacer();
        computeMetrics(arry);
        spacer();
    }

    private static void printSales(double[] stuff)
    {int x = 0;
        while(x < load)
        {
            //System.out.println(x);
            System.out.println(String.format("%.2f", stuff[x]));
            x++;

        }
    }

    private static void computeMetrics(double[] stuff)
    {
        double total = 0, high = 0, low = stuff[0], mean = 0;

        for(int x = 0; x < load; x++)
        {
            total = total + stuff[x];

            if(high < stuff[x])
            {
                high = stuff[x];
            }

            if(low > stuff[x])
            {
                low = stuff[x];
            }
        }

        mean = total / load;
       iii
    }

    private static void catchcall()
    {
        try {
            System.out.print("How many sales would you like to load? ");
            String inp = reader.nextLine();
            load = Integer.parseInt(inp);
        }
        catch(Exception e){
            System.out.println("Please input a proper value.");
            catchcall();
        }
    }

    private static void spacer()
    {
        System.out.println("------------------------------");
    }
}
