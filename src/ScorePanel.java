import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Juan Fernandez on 9/28/2016.
 */

public class ScorePanel extends JPanel {



    public ScorePanel() {
        super(new GridLayout(1, 0));



                String[] columnNames = {"Rules"};
                String[][] data = {{"Ones"},
                        {"Twos"},
                        {"Threes"},
                        {"Fours"},
                        {"Fives"},
                        {"Sixes"},
                        {"SUM"},
                        {"BONUS"},
                        {"Pair"},
                        {"Two Pairs"},
                        {"Three of a Kind"},
                        {"Four of a Kind"},
                        {"Small Ladder"},
                        {"Big Ladder"},
                        {"Full House"},
                        {"Chance"},
                        {"Yathzee"},
                        {"TOTAL"}
                };





        final JTable table = new JTable(data, columnNames);
        this.add(new JScrollPane(table));
        setBackground(Color.white);
        table.setPreferredSize(new Dimension(200, 740));
        table.setFont(new Font("", Font.CENTER_BASELINE,22));
        table.setRowHeight(41);
        table.setEnabled(false);


        table.addMouseListener(new MouseListener() {
            Player playerOne = null;
            Player playerTwo = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(data[table.rowAtPoint(e.getPoint())][0]);
                int result = 0;

                playerOne = PlayerPanel.player.get(0);
                playerTwo = PlayerPanel.player.get(1);

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Ones")){
                    result = Rules.ones();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);


                        System.out.println("One");
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }
                if(data[table.rowAtPoint(e.getPoint())][0].equals("Twos")){
                    result = Rules.twoes();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }
                if(data[table.rowAtPoint(e.getPoint())][0].equals("Threes")){
                    result = Rules.threes();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }
                if(data[table.rowAtPoint(e.getPoint())][0].equals("Fours")){
                    result = Rules.fours();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }
                if(data[table.rowAtPoint(e.getPoint())][0].equals("Fives")){
                    result = Rules.fives();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Sixes")){
                    result = Rules.sixes();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Pair")){
                    result = Rules.onePair();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Two Pairs")){
                    result = Rules.twoPair();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }
                if(data[table.rowAtPoint(e.getPoint())][0].equals("Three of a Kind")){
                    result = Rules.threeOfAKind();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Four of a Kind")){
                    result = Rules.fourOfAKind();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Small Ladder")){
                    result = Rules.smalStraight();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Big Ladder")){
                    result = Rules.largeStraight();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Full House")){
                    result = Rules.fullHouse();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Chance")){
                    result = Rules.chance();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }

                if(data[table.rowAtPoint(e.getPoint())][0].equals("Yathzee")){
                    result = Rules.yahtzee();
                    if(MyDice.selectedPlayer%2 == 0) {
                        playerOne.setScore(result);
                    }
                    else {
                        playerTwo.setScore(result);
                    }
                }


                int option = JOptionPane.showConfirmDialog(null, "You will get " + result +
                        " points", "Points confirm dialog", JOptionPane.OK_CANCEL_OPTION);

                if(option == JOptionPane.OK_OPTION) {
                    MyDice.updateScore();
                    PlayerPanel.addText(data[table.rowAtPoint(e.getPoint())][0]);
                }

                //System.out.println(playerOne.getScore());
                //System.out.println(playerTwo.getScore());

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        setVisible(true);

    }

}










