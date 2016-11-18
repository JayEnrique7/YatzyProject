import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Juan Fernandez on 9/28/2016.
 */

public class MyDice extends JPanel{

    static ArrayList<Dice> dices = new ArrayList<>();
    static int selectedPlayer;
    private int counter;
    private int round;

    static JLabel scoreLabel;


    public MyDice(){

        for(int i = 0; i < 5; i++){
            dices.add(new Dice());
            add(dices.get(i));
        }

        counter = 1;
        round = 1;
        setPreferredSize(new Dimension(400, 600));
        setLayout(new GridLayout(4,2));
        setVisible(true);

        scoreLabel = new JLabel();
        updateScore();

        add(scoreLabel);



        setDoneButton();
        setRollButton();

    }

    public void setRollButton(){
        JButton roll = new JButton("Roll");
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter < 3){
                    for(Dice d: dices){
                        d.setValue((int) (Math.random() * 6 + 1));
                        System.out.println(d.getValue() + " Roll Button");
                    }
                }
                else {
                    for (Dice d : dices){
                        d.setEnabled(false);
                    }
                }
                counter++;
            }
        });
        add(roll);
    }

    public void setDoneButton(){
        JButton done = new JButton("Done");
        /* TO-DO
        add actionListener for done button as in setRollButton
         */
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPlayer++;
                for (Dice d : dices) {
                    d.setEnabled(true);
                    d.diceImage.refreshDices(false);
                    d.setValue((int) (Math.random() * 6 + 1));
                    System.out.println(d.getValue() + " Done Button");


                }

                if(round == 32){
                    String winningMsg = null;
                    Player playerOne = PlayerPanel.player.get(0);
                    Player playerTwo = PlayerPanel.player.get(1);
                    if(playerOne.getScore() > playerTwo.getScore()){
                        winningMsg = "Player " + playerOne.getName() + "vann!" +
                                "\n" + playerOne.getName() + "had " + playerOne.getScore() + " points" +
                                "\n" + playerTwo.getName() + "had " + playerTwo.getScore() + " points";
                    }
                    else {
                        winningMsg = "Player " + playerTwo.getName() + "vann!" +
                                "\n" + playerTwo.getName() + "had " + playerTwo.getScore() + " points" +
                                "\n" + playerOne.getName() + "had " + playerOne.getScore() + " points";
                    }
                    JOptionPane.showMessageDialog(null, winningMsg, "Title", JOptionPane.OK_OPTION);
                    System.exit(0);
                }
                round++;
                counter = 1;
                updateScore();
            }
        });



        add(done);
    }

    public static ArrayList<Dice> getDiceList(){
        return dices;
    }

    public static void updateScore(){
        int sum = 0;
        for(Dice d: dices){

            if(d.isLocked()) {

                sum += d.getValue();
            }
        }
        //scoreLabel.setText("Points: " + sum);
        if(selectedPlayer%2 == 0) {
            scoreLabel.setText(PlayerPanel.player.get(0).getName() +
                    ", points " + PlayerPanel.player.get(0).getScore());
        }
        else {
            scoreLabel.setText(PlayerPanel.player.get(1).getName() +
                    ", points: " + PlayerPanel.player.get(1).getScore());
        }
    }
}
