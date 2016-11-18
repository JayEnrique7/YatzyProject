import javax.swing.*;
import java.util.*;

/**
 * Created by Juan Fernandez on 9/28/2016.
 */

public class DiceImage{

    ArrayList<ImageIcon> openDice = new ArrayList<>();
    ArrayList<ImageIcon> takenDice = new ArrayList<>();
    public Boolean isTaken = false;

    public DiceImage() {
        loadImage();
    }

    public void loadImage(){
        openDice.add(new ImageIcon(("Image/dice1.png")));
        openDice.add(new ImageIcon(("Image/dice2.png")));
        openDice.add(new ImageIcon(("Image/dice3.png")));
        openDice.add(new ImageIcon(("Image/dice4.png")));
        openDice.add(new ImageIcon(("Image/dice5.png")));
        openDice.add(new ImageIcon(("Image/dice6.png")));

        takenDice.add(new ImageIcon(("Image/diceLocked1.png")));
        takenDice.add(new ImageIcon(("Image/diceLocked2.png")));
        takenDice.add(new ImageIcon(("Image/diceLocked3.png")));
        takenDice.add(new ImageIcon(("Image/diceLocked4.png")));
        takenDice.add(new ImageIcon(("Image/diceLocked5.png")));
        takenDice.add(new ImageIcon(("Image/diceLocked6.png")));
    }


    public ImageIcon getDiceImage(int x){
        if(isTaken){
            return takenDice.get(x-1);
        }
        else {
            return openDice.get(x-1);
        }
    }
    public boolean refreshDices(Boolean bool){
        return this.isTaken = bool;
    }

    public void toggleLock(){
        if(isTaken){
            isTaken = false;
        }
        else{
            isTaken = true;
        }
    }

    public boolean isLocked(){
        return this.isTaken;
    }




/*
    public void diceNotLocked(int diceValue) {
        if (diceValue >= 1 && diceValue <= 6) {
            setIcon(icons[diceValue - 1]);

        }
    }


    public void diceLocked(int diceValue) {
        if (diceValue >= 1 && diceValue <= 6) {
            setIcon(iconsLocked[diceValue - 1]);

        }
    }
*/


}
