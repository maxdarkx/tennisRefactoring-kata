
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String namePlayer1;
    private final String namePlayer2;

    public TennisGame1(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(namePlayer1))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder("");

        if (scorePlayer1==scorePlayer2)
        {
            getScoreStage1(score, scorePlayer1);
        }
        else
        {
            getScoreStage2(score);
        }


        return score.toString();
    }

    private void getScoreStage2(StringBuilder score) {
        if(scorePlayer1>=4 || scorePlayer2>=4)
        {
            getScoreStage4(score);
        }
        else
        {
            getFinalScore(score);
        }
    }

    private void  getFinalScore(StringBuilder score) {
        int tempScore;
        for (int i=1; i<3; i++) {
            if (i == 1)
            {
                tempScore = scorePlayer1;
            }
            else
            {
                score.append("-");
                tempScore = scorePlayer2;
            }

            getScoreStageEquals(score, tempScore);
        }
    }

    private void getScoreStage4(StringBuilder score) {
        int minusResult = scorePlayer1-scorePlayer2;

        if (minusResult==1) score.append("Advantage ").append(namePlayer1);
        if (minusResult ==-1) score.append("Advantage ").append(namePlayer2);
        getScoreStage5(score, minusResult);
    }

    private void getScoreStage5(StringBuilder score, int minusResult) {
        if (minusResult > 1) score.append("Win for ").append(namePlayer1);
        if (minusResult < -1)
        {
            score.append("Win for ").append(namePlayer2);
        }
    }

    private void getScoreStage1(StringBuilder score, int scorePlayer1){

        switch (scorePlayer1)
        {
            case 0:
                    score.append("Love-All");
                break;
            case 1:
                    score.append( "Fifteen-All");
                break;
            case 2:
                    score.append("Thirty-All");
                break;
            default:
                    score.append("Deuce");
                break;

        }
    }

    private void getScoreStageEquals(StringBuilder score, int tempScore) {
        switch(tempScore)
        {
            case 1:
                score.append("Fifteen");
                break;
            case 2:
                score.append("Thirty");
                break;
            case 3:
                score.append("Forty");
                break;
            default:
                score.append("Love");
                break;
        }
    }
}
