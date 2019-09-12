package tennis;

public class Player {

    private String name;
    private int score;

    public Player() {
        this("Player");
    }

    Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
    }
}
