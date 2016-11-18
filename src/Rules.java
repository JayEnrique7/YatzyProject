import java.util.*;

/**
 * Created by Juan Fernandez on 10/13/2016.
 */
public class Rules {

    static ArrayList<Integer> checkPoints = new ArrayList<>();


    private static void addToList(int value){
        checkPoints.add(value);
    }


    private static int sum(int value) {
        int sum = 0;
        ArrayList<Dice> dices = MyDice.dices;

        for (int i = 0; i < dices.size(); i++) {
            if (dices.get(i).getValue() == value) {
                sum += value;
            }
        }

        addToList(sum);
        return sum;
    }


    public static int ones() {
        return sum(1);
    }

    public static int twoes() {
        return sum(2);
    }

    public static int threes() {
        return sum(3);
    }

    public static int fours() {
        return sum(4);
    }

    public static int fives() {
        return sum(5);
    }

    public static int sixes() {
        return sum(6);
    }


    private static ArrayList<Dice> sortList() {
        ArrayList<Dice> dices = MyDice.dices;
        for (int i = 0; i < dices.size(); i++) {
            for (int n = i + 1; n < dices.size(); n++) {
                if (dices.get(i).getValue() > dices.get(n).getValue()) {
                    Dice temp = dices.get(i);
                    dices.set(i, dices.get(n));
                    dices.set(n, temp);

                }
            }
        }

        return dices;
    }

    public static int onePair() {
        ArrayList<Dice> dices = sortList();

        for (int i = dices.size() - 1; i > 0; i--) {
            if (dices.get(i).getValue() == dices.get(i - 1).getValue()) {
                int result = dices.get(i).getValue() * 2;
                addToList(result);
                return result;
            }
        }

        return 0;
    }


    public static int twoPair() {
        ArrayList<Dice> dices = sortList();

        int sum = 0;
        for (int i = dices.size() - 1; i > 0; i--) {
            if (dices.get(i).getValue() == dices.get(i - 1).getValue()) {
                sum = dices.get(i).getValue() * 2;

                for (int n = i - 1; n > 0; n--) {
                    if (dices.get(n).getValue() == dices.get(n - 1).getValue()) {
                        int result = dices.get(n).getValue() * 2;
                        addToList(result);
                        return result;
                    }
                }
            }
        }
        return 0;
    }

    public static int threeOfAKind() {
        ArrayList<Dice> dices = sortList();

        for (int i = dices.size() - 1; i > 1; i--) {
            if (dices.get(i).getValue() == dices.get(i - 1).getValue() && dices.get(i).getValue() == dices.get(i - 2).getValue()) {
                int result = dices.get(i).getValue() * 3;
                addToList(result);
                return result;

            }
        }
        return 0;
    }


    public static int fourOfAKind() {
        ArrayList<Dice> dices = sortList();

        for (int i = dices.size() - 1; i > 2; i--) {
            if (dices.get(i).getValue() == dices.get(i - 1).getValue() && dices.get(i).getValue() == dices.get(i - 2).getValue() &&
                    dices.get(i).getValue() == dices.get(i - 3).getValue()) {
                int result = dices.get(i).getValue() * 4;
                addToList(result);
                return result;
            }
        }
        return 0;
    }

    public static int smalStraight() {
        ArrayList<Dice> dices = sortList();

        int[] correct = {1, 2, 3, 4, 5};

        for (int i = 0; i < dices.size(); i++) {

            if (!(dices.get(i).getValue() == correct[i])) {
                return 0;
            }
        }
        addToList(15);
        return 15;
    }

    public static int largeStraight() {
        ArrayList<Dice> dices = sortList();

        int[] correct = {2, 3, 4, 5, 6};

        for (int i = 0; i < dices.size(); i++) {

            if (!(dices.get(i).getValue() == correct[i])) {
                return 0;
            }
        }
        addToList(20);
        return 20;
    }

    public static int fullHouse() {
        return onePair() + threeOfAKind();
    }

    public static int chance() {
        ArrayList<Dice> dices = MyDice.dices;
        int sum = 0;
        for (Dice d : dices) {
            sum += d.getValue();
        }
        addToList(sum);
        return sum;
    }


    public static int yahtzee() {
        ArrayList<Dice> dices = sortList();

        if (dices.get(0).getValue() == dices.get(dices.size() - 1).getValue()) {
            addToList(50);
            return 50;
        }
        return 0;
    }


}