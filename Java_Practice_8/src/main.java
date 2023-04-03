import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;

public class main extends JFrame {

    private static JTextField SEARCH_AREA = new JTextField("");
    private static JButton SEARCH = new JButton("Search");
    private static JLabel RESULTS = new JLabel("Please enter a state... ");
    private static Map<String, State> hashmaping = new HashMap<String, State>();

    public static void main(String[] args)
    {

        File file = new File("res/unemployment.csv");
        Scanner reader = null;

        try
        {
            reader = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error, no file found");
        }

        reader.nextLine(); //remove header
        while(reader.hasNext())
        {
            String line = reader.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",\n");

            String abe = tokenizer.nextToken();
            String state = tokenizer.nextToken();
            Float rates = Float.parseFloat(tokenizer.nextToken());
            State current_data = new State(abe, state, rates);

            hashmaping.put(abe.toLowerCase(), current_data);

        }

        interface_create();
        System.out.println(hashmaping);

    }

    public static void interface_create()
    {
        GUI Window = new GUI("Assignment 4", 400, 200, null);
        JFrame Main = Window.Create_GUI();
        GridBagLayout a = new GridBagLayout();
        GBC layout = new GBC();
        Main.setLayout(a);

        Main.add(new JLabel("ENTER STATE:"), layout.gbc(0, 0, GridBagConstraints.EAST,0, 0, 1, 1));
        Main.add(SEARCH_AREA, layout.gbc(1, 0, GridBagConstraints.HORIZONTAL,100, 10, 1, 1));
        Main.add(SEARCH, layout.gbc(2, 0,  GridBagConstraints.NONE,10, 0, 1, 1));
        Main.add(RESULTS, layout.gbc(1, 1, GridBagConstraints.BOTH, 0, 0, 1, 1, 3, 1));

        SEARCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String abbrevation = SEARCH_AREA.getText().toLowerCase();
                System.out.println(abbrevation);
                searching(abbrevation);

            }
        });



        Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.setLocationRelativeTo(null);
        Main.setVisible(true);

    }


    public static void searching(String abbrivation)
    {

        if(hashmaping.containsKey(abbrivation))
        {
            RESULTS.setText("The unemployment in " + hashmaping.get(abbrivation).getState_name() + " is " + hashmaping.get(abbrivation).getRates() + "%");

        }
        else
        {
            JOptionPane.showMessageDialog(null, "State not found", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }


}
