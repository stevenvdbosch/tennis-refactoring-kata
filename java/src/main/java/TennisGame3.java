
public class TennisGame3 implements TennisGame {
    
    private int player2Score;
    private int player1Score;
    private final String player1Name;
    private final String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (player1Score < 4 && player2Score < 4 && !(player1Score + player2Score == 6)) {
            String[] scoreNames = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            String score1Name = scoreNames[player1Score];
            String score2Name = scoreNames[player2Score];
            return (player1Score == player2Score) ? score1Name + "-All" : score1Name + "-" + score2Name;
        } else {
            if (player1Score == player2Score)
                return "Deuce";
            String playerName = player1Score > player2Score ? player1Name : player2Name;
            return ((player1Score - player2Score)*(player1Score - player2Score) == 1) ? "Advantage " + playerName : "Win for " + playerName;
        }
    }
    
    public void wonPoint(String playerName) {
        if (!isExistingPlayer(playerName)) {
            throw new IllegalArgumentException("Invalid player name");
        }

        if (player1Name.equals(playerName)) {
            this.player1Score += 1;
        } else {
            this.player2Score += 1;
        }

    }

    private boolean isExistingPlayer(String playerName) {
        return player1Name.equals(playerName) || player2Name.equals(playerName);
    }

}
