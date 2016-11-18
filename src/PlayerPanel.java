import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Juan Fernandez on 10/14/2016.
 */
public class PlayerPanel extends JPanel{
    private static JTextArea text1, text2;
    private static PlayerPanel instance = null;
    static ArrayList<Player> player;

    private PlayerPanel() {
        //String[][] data = new String[32][32];
        //String[] columnNames = {"a","b"};

        JPanel firstPlayer = new JPanel();
        JPanel secondPlayer = new JPanel();

        player = new ArrayList<>();
        String name1 = JOptionPane.showInputDialog(null, "Insert the name of the player \nnumber one please.", "Welcome to Yathzee", JOptionPane.QUESTION_MESSAGE);
        if (name1 == null) {
            System.exit(0);
        } else if (!name1.equals("")) {
            player.add(new Player(name1, 0));
        } else {
            System.exit(0);
        }

        String name2 = JOptionPane.showInputDialog(null, "Insert the name of the player \nnumber two please.", "Welcome to Yathzee", JOptionPane.QUESTION_MESSAGE);

        if (name2 == null) {
            System.exit(0);
        } else if (!name2.equals("")) {
            player.add(new Player(name2, 0));

        } else {
            System.exit(0);
        }


        firstPlayer.setPreferredSize(new Dimension(100, 740));
        secondPlayer.setPreferredSize(new Dimension(100, 740));
        setLayout(new GridLayout(1, 1));

        text1 = new JTextArea();
        text2 = new JTextArea();

        firstPlayer.setLayout(new GridLayout(1, 1));
        secondPlayer.setLayout(new GridLayout(1, 1));

        firstPlayer.add(new JLabel(name1));
        secondPlayer.add(new JLabel(name2));

        firstPlayer.add(text1);
        secondPlayer.add(text2);

        add(firstPlayer);
        add(secondPlayer);

    }

    public static PlayerPanel getInstance(){
        if(instance == null){
            instance = new PlayerPanel();
        }
        return instance;
    }

    public static void addText(String value){
        if(!(value.equals("TOTAL") || value.equals("SUM") || value.equals("BONUS"))){
            if(MyDice.selectedPlayer%2 == 0){
                text1.append(value + "\n");
            }
            else {
                text2.append(value + "\n");
            }
        }



    }

}



