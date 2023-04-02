import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        int A=0, B=0, R1=0, R2=0;
        String indet;

        // TODO: greet the user
        System.out.print("This program computes the GCD (Greatest common divisor) of two positive integers.");

        // TODO: read first integer (repeat until positive)
        while(A <= 0){
            System.out.print("\nWhat is your 1st integer: ");
            A = R1 = Integer.parseInt(indet = reader.nextLine());
        }

        // TODO: read second integer (repeat until positive)
        while(B <= 0){
            System.out.print("\nWhat is your 2nd integer: ");
            B = R2 = Integer.parseInt(indet = reader.nextLine());
        }

        // TODO: compute GCD
        while(B != 0){
            if (A > B){
                A = A - B;
            }
            else{
                B = B - A;
            }
        }

        // TODO: print out answer
        System.out.print("\n\n The GCD of " + String.valueOf(R1) + " & " + String.valueOf(R2) + " is : " + String.valueOf(A) );
    }
}
