package tennis;

public class TennisGame {

    private Player player_1;
    private Player player_2;

    public TennisGame() {
        this.player_1 = new Player("Player1");
        this.player_2 = new Player("Player2");
    }

    public String point(int player) {
        if (player == 1) {
            updateScore(player_1, player_2);
        } else if (player == 2) {
            updateScore(player_2, player_1);
        } else if (player == 0) {
            resetScore();
        }
        return getScoreDescription();
    }

    private String getScoreDescription() {
        if ((player_1.getScore() == 40 && player_2.getScore() == 40)) {
            return "deuce";
        } else if (player_1.getScore() == 41 && player_2.getScore() == 40) {
            return "Advantage player 1";
        } else if (player_1.getScore() == 40 && player_2.getScore() == 41) {
            return "Advantage player 2";
        } else if ((player_1.getScore() == 42) || (player_1.getScore() == 41 && player_2.getScore() < 40)) {
            resetScore();
            return "Game won by player 1";
        } else if ((player_2.getScore() == 42) || (player_2.getScore() == 41 && player_1.getScore() < 40)) {
            resetScore();
            return "Game won by player 2";
        } else  {
            return player_1.getScore() + " - " + player_2.getScore();
        }
    }

    private void resetScore() {
        player_1.setScore(0);
        player_2.setScore(0);
    }

    private void updateScore(Player player, Player opponent) {
        if (player.getScore() == 40 && opponent.getScore() == 40) {
            player.setScore(41);
        } else if (player.getScore() == 41 && opponent.getScore() == 40) {
            player.setScore(42);
        } else if (player.getScore() == 40 && opponent.getScore() == 41) {
            player.setScore(40);
            opponent.setScore(40);
        } else {
            updateScore(player);
        }
    }

    private void updateScore(Player player) {
        switch (player.getScore()) {
            case 0:
                player.setScore(15);
                break;
            case (15):
                player.setScore(30);
                break;
            case (30):
                player.setScore(40);
                break;
            case (40):
                player.setScore(41);
                break;
        }
    }
}
