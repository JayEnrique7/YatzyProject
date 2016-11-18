import javax.swing.*;
import java.awt.*;
import java.awt.Component;

/**
 * Created by Juan Fernandez on 9/28/2016.
 */


public class Main{

    public static void main(String[] arg) {






        JFrame myJframe = new JFrame();
        myJframe.setLayout(new GridLayout(0, 3));
        PlayerPanel playerPanel = PlayerPanel.getInstance();
        ScorePanel scorePanel = new ScorePanel();
        MyDice myDice = new MyDice();
        myJframe.setTitle("Yatzy");
        myJframe.add(scorePanel);
        myJframe.add(playerPanel);
        myJframe.add(myDice);
        myJframe.setResizable(false);
        myJframe.setVisible(true);
        myJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJframe.setSize(1200, 800);

    }
}