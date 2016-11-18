/**
 * Created by Juan Fernandez on 10/11/2016.
 */
//public abstract class Player {
public class Player {
    private String name;
    private int score = 0;

    //public Player(String name){
    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;

    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score; }
}
