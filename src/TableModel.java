import javax.swing.table.*;
import java.util.*;


/**
 * Created by Juan Fernandez on 10/11/2016.
 */
/*public class TableModel extends AbstractTableModel implements Observer {

    Rules rules;



    @Override
    public int getRowCount() {
        return rules.checkPoints.size();
    }

    @Override
    public int getColumnCount() {
        System.out.println(PlayerPanel.player.size());
        return PlayerPanel.player.size();
    }

    @Override
    public String getColumnName(int column) {

        return PlayerPanel.player.get(column).getName();
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        String[] data = {"Ones","Twos","Threes", "Fours", "Fives", "Sixes", "SUM", "BONUS", "Pair", "Two Pairs",
                "Three of a Kind", "Four of a Kind", "Small Ladder", "Big Ladder", "Full House", "Chance", "Yahzee",
                "TOTAL"};



        Player p = PlayerPanel.player.get(columnIndex);

        if(columnIndex == 0){
            return data[rowIndex];
        }

        if(columnIndex == MyDice.selectedPlayer && rules.ones() + rules.twoes() + rules.threes() + rules.fours() +
                rules.fives() + rules.sixes() + rules.onePair() + rules.twoPair() + rules.threeOfAKind() +
                rules.smalStraight() + rules.largeStraight() + rules.fullHouse() + rules.chance() + rules.yahtzee() > 0)
        {
            return null;
        }
        return null;
       }






    @Override
    public void update(Observable o, Object arg){
        fireTableDataChanged();
        System.out.println("Vi är här");

    }


}*/



