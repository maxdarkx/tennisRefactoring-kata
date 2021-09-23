import java.util.ArrayList;
import java.util.Arrays;

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
        int sumScore = player1Score + player2Score;
        return getScoreStage3(sumScore);
    }

    private String getScoreStage3(int sumScore) {
        ArrayList <String> scoreText = new ArrayList<>(Arrays.asList("Love", "Fifteen", "Thirty", "Forty"));
        boolean scoreTest1 = player1Score >= 4;
        boolean scoreTest2 = player2Score >= 4;
        boolean scoreTest3 = sumScore == 6;
        boolean scoreTest4 = scoreTest1 || scoreTest2;

        return getScoreStage5(scoreText, scoreTest3, scoreTest4);
    }

    private String getScoreStage5(ArrayList<String> scoreText, boolean scoreTest3, boolean scoreTest4) {
        return scoreTest3 || scoreTest4 ? getScoreStage1() : getScoreStage2(scoreText);
    }

    private String getScoreStage2(ArrayList<String> scoreText) {
        String score;
        score = scoreText.get(player1Score);
        return (player1Score == player2Score) ? score + "-All" : score + "-" + scoreText.get(player2Score);
    }

    private String getScoreStage1() {
        String score;
        score = getScoreEquals();
        if (score == null) return "Deuce";
        return getScoreStage3(score);
    }

    private String getScoreEquals() {

        if (player1Score == player2Score)
            return null;
        return player1Score > player2Score ? player1Name : player2Name;
    }

    private String getScoreStage3(String score) {

        int calcScore = (player1Score - player2Score) * (player1Score - player2Score);
        StringBuilder result = new StringBuilder("");

        if (calcScore == 1)
            result.append("Advantage ").append(score);
        else result.append("Win for ").append(score);
        return result.toString();

    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.player1Score += 1;
        else
            this.player2Score += 1;
        
    }

}
