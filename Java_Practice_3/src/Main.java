import java.util.Scanner;

public class Main
{
    private static Scanner Reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print("How many shapes do you want? ");
        int count = Integer.valueOf(Reader.nextLine());
        boolean Con = true;

        Shape[] shapes = new Shape[count];

        fillShapes(shapes);

        while (Con)
        {
            printShapes(shapes);
            printMenu();

            System.out.println("Which menu item would you like?");
            count = Integer.parseInt(Reader.nextLine());
            System.out.println("Which shape would you like the index of? ");
            int shape_num = Integer.parseInt(Reader.nextLine());

            switch(count)
            {
                case 1:
                    System.out.println("Area: " + String.format("%.2f", shapes[shape_num].area()));
                    break;
                case 2:
                    System.out.println("Perimeter: " + String.format("%.2f", shapes[shape_num].perimeter()));
                    break;
                case 3:
                    Con = false;
                    break;

            }
        }
    }

    private static void fillShapes(Shape[] stuff)
    {


        for(int x = 0; x < stuff.length; x++)
        {
            double topcord_x = 0;
            double topcord_y = 0;
            double height = 1;
            double width = 1;
            double radius = 1;

            System.out.print("Is your shape a circle? (y/n): ");
            String choice = Reader.nextLine();

            if(choice.equals("y") || choice.equals("yes") || choice.equals("Y") || choice.equals("Yes"))
            {
                System.out.print("What is your x-pos cord?: ");
                choice = Reader.nextLine();
                topcord_x = Double.parseDouble(choice);

                System.out.print("What is your y-pos cord?: ");
                choice = Reader.nextLine();
                topcord_y = Double.parseDouble(choice);

                System.out.print("What is your Radius?: ");
                choice = Reader.nextLine();

                if(Double.parseDouble(choice) <= 0)
                {
                    radius = 1;
                }
                else
                {
                    radius = Double.parseDouble(choice);
                }

                stuff[x] = new Circle(topcord_x, topcord_y, radius);
            }
            else
            {
                System.out.print("What is your x-pos cord?: ");
                choice = Reader.nextLine();
                topcord_x = Double.parseDouble(choice);

                System.out.print("What is your y-pos cord?: ");
                choice = Reader.nextLine();
                topcord_y = Double.parseDouble(choice);

                System.out.print("What is your height?: ");
                choice = Reader.nextLine();

                if(Double.parseDouble(choice) <= 0)
                {
                    height = 1;
                }
                else
                {
                    height = Double.parseDouble(choice);
                }

                System.out.print("What is your width?: ");
                choice = Reader.nextLine();

                if(Double.parseDouble(choice) <= 0)
                {
                    width = 1;
                }
                else
                {
                    width = Double.parseDouble(choice);
                }


                stuff[x] = new Rectangle(topcord_x, topcord_y, height, width);
            }
        }
    }

    private static void printShapes(Shape[] stuff)
    {
        System.out.println("\n--------------------");
        for(int x = 0; x < stuff.length; x++)
        {
            System.out.println(String.valueOf(x) + "} " + stuff[x].toString());
        }
        System.out.println("--------------------\n");
    }

    private static void printMenu()
    {
        System.out.println("--------------------");
        System.out.println("1) Area");
        System.out.println("2) Perimeter");
        System.out.println("3) EXIT");
        System.out.println("--------------------");
    }
}