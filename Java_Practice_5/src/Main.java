import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main
{
    public static void main(String[] args)
    {
        LinkedList<Student> students = loadStudents();
        ArrayList<Double> constants = loadConstants();
        Printstuff(constants);
        System.out.println("UNSORTED: \n");
        Printstuff(students);

        Collections.sort(students);
        System.out.println("SORTED FIRST BY FIRST NAME: \n");
        Printstuff(students);

        Collections.sort(students, Collections.reverseOrder());
        System.out.println("SORTED LAST BY FIRST NAME: \n");
        Printstuff(students);

        trimStudents(students);
        Collections.sort(students);
        System.out.println("SORTED BY ONLY A's: \n");
        Printstuff(students);

    }


    public static <E> void Printstuff(List<E> stuff)
    {
        for (E element : stuff)
            System.out.print(element + "\n");
        System.out.println();
    }

    private static LinkedList<Student> loadStudents()
    {
        File file = new File("res/roster.csv");
        Scanner reader;

        try
        {
            reader = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Could not find file: " + file.toPath());
            return null;
        }

        LinkedList<Student> students = new LinkedList<Student>();

        reader.nextLine(); // eat header
        while (reader.hasNext())
        {
            String line = reader.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",\n");

            String last = tokenizer.nextToken();
            String first = tokenizer.nextToken();
            float grade = Float.valueOf(tokenizer.nextToken());

            Student s = new Student(first, last, grade);
            students.add(s);
        }

        return students;
    }

    private static ArrayList<Double> loadConstants()
    {
        File file = new File("res/constants.txt");
        Scanner reader;

        try
        {
            reader = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Could not find file: " + file.toPath());
            return null;
        }

        ArrayList<Double> constants = new ArrayList<Double>();

        reader.nextLine();
        while (reader.hasNext())
        {
            String line = reader.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",\n");
            Double C = Double.valueOf(tokenizer.nextToken());
            constants.add(C);
        }

        return constants;
    }

    public static void trimStudents(LinkedList<Student> stuff)
    {
        Iterator<Student> e = stuff.iterator();
        double A_grade = 90.0;
        while(e.hasNext())
        {
            Student grade = e.next();
            if(grade.Get_grade() < A_grade)
                e.remove();

        }
    }

}
