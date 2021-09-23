
import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    private int player1Points = 0;
    private int player2Points = 0;
    
    private String player1Result = "";
    private String player2Result = "";
    private String player1Name;
    private String player2Name;
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String FIFTEEN = "Fifteen";


    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (player1Points == player2Points) {
            score = getScoreStage8(score);
        }
        score = getScoreStage9(score);

        if (player1Points > 0) {
            score = getScoreStage16(score);
        }
        if (player2Points > 0) {
            score = getScoreStage18(score);
        }

        score = getScoreStage10(score);
        score = getScoreStage11(score);
        score = getScoreStage12(score);
        score = getScoreStage13(score);
        score = getScoreStage14(score);
        return score;
    }

    private String getScoreStage18(String score) {
        if (player1Points == 0) {
            score = getScoreStage3();
        }
        return score;
    }

    private String getScoreStage16(String score) {
        if (player2Points == 0) {
            score = getScoreStage2();
        }
        return score;
    }

    private String getScoreStage14(String score) {
        if (player2Points >= 4)
            if (player1Points >= 0)
                if ((player2Points - player1Points) >= 2) {
                    score = "Win for player2";
                }
        return score;
    }

    private String getScoreStage13(String score) {
        if (player1Points >= 4)
            if (player2Points >= 0 && (player1Points - player2Points) >= 2) {
                score = "Win for player1";
            }
        return score;
    }

    private String getScoreStage12(String score) {
        if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
        return score;
    }

    private String getScoreStage11(String score) {
        if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
        return score;
    }

    private String getScoreStage10(String score) {
        if (player2Points > player1Points && player2Points < 4)
        {
            score = getScoreStage5();
        }
        return score;
    }

    private String getScoreStage9(String score) {
        if (player1Points > player2Points)
            if (player1Points < 4) {
                score = getScoreStage4();
            }
        return score;
    }

    private String getScoreStage8(String score) {
        if (player1Points < 4) {
            score = getScoreStage1();
        }
        if (player1Points >= 3) {
            score = "Deuce";
        }
        return score;
    }

    private String getScoreStage5() {
        String score;
        switch(player2Points)
        {
            case (3):
                player2Result =FORTY;
                break;
            case (2):
                player2Result = THIRTY;
        }

        switch(player1Points) {
            case (1):
                player1Result =FIFTEEN;
                break;
            case (2):
                player1Result =THIRTY;
        }
        score = player1Result + "-" + player2Result;
        return score;
    }

    private String getScoreStage4() {
        String score;

        switch(player1Points)
        {
            case(2):
                player1Result =THIRTY;
                break;
            case(3):
                player1Result = FORTY;
        }

        switch(player2Points)
        {
            case(1):
                player2Result = FIFTEEN;
                break;
            case(2):
                player2Result = THIRTY;
        }

        score = player1Result + "-" + player2Result;
        return score;
    }

    private String getScoreStage3() {
        String score;

        switch(player2Points)
        {
            case (1):
                player2Result = FIFTEEN;
                break;
            case (2):
                player2Result = THIRTY;
                break;
            default:
                player2Result = FORTY;
        }
        player1Result = "Love";
        score = player1Result + "-" + player2Result;
        return score;
    }

    private String getScoreStage2() {
        switch (player1Points)
        {
            case (2):
                player1Result = THIRTY;
                break;
            case (3):
                player1Result = FORTY;
                break;
            default:
                player1Result = FIFTEEN;
        }
        player2Result = "Love";
        return player1Result + "-" + player2Result;
    }

    private String getScoreStage1() {
        String score = "";
        switch (player1Points) {
            case (1):
                score = "Fifteen-All";
                break;
            case (2):
                score = "Thirty-All";
                break;
            default:
                score = "Love-All";
        }
        return score;
    }

    public void setPlayer1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player1Score();
        }

    }
    
    public void setPlayer2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player2Score();
        }

    }
    
    public void player1Score(){
        player1Points++;
    }
    
    public void player2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            player1Score();
        else
            player2Score();
    }
}