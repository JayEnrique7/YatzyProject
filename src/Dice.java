import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Juan Fernandez on 9/28/2016.
 */

public class Dice extends JButton{
    DiceImage diceImage;
    int diceValue;

    public Dice(){
        diceImage = new DiceImage();
        diceValue = (int) (Math.random() * 6 + 1);
        setIcon(diceImage.getDiceImage(diceValue));
        System.out.println(getValue() + " Dice class");
        setActionListener();

    }

    private void setActionListener(){
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
                diceImage.toggleLock();
                //MyDice.updateScore();
                setIcon(diceImage.getDiceImage(diceValue));
            }
        });
    }


    public void mouseClicked(){
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

    }


    public void setValue(int diceValue){
        if(!diceImage.isLocked()){
            this.diceValue = diceValue;
            setIcon(diceImage.getDiceImage(diceValue));
        }
    }

    public int getValue(){

        return this.diceValue;

    }

    public boolean isLocked(){
        return diceImage.isLocked();
    }

    @Override
    public String toString(){
        return String.valueOf(this.diceValue);
    }


}
