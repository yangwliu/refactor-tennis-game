package cn.xpbootcamp.tennis;

public class TennisGameImpl implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    private String player1Name;
    private String player2Name;
    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }


    public String getScore() {

        String P1res = "";
        String P2res = "";
        String score = "";
        if (isSamePoint()) {
            return handleSameScore();
        }

        if (someWon()) {
            return handleSomeWon();
        }

        if (P1point >= 3 && P2point >= 3) {
            return handleAllPlayerPointNotLess3();
        }

        return handleAllPlayerPointLess3();
    }

    private boolean isSamePoint() {
        return P1point == P2point;
    }

    private String handleAllPlayerPointLess3() {
        String player1Score = getScoreTextForNotBiggerThan3(P1point);
        String player2Score = getScoreTextForNotBiggerThan3(P2point);
        return player1Score + "-" + player2Score;
    }

    private String getScoreTextForNotBiggerThan3(int point) {
        if (point > 3) {
            throw new IllegalArgumentException("point should not bigger than 3");
        }
        switch (point) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3:
            default:
                return "Forty";
        }
    }

    private String handleSomeWon() {
        if (P1point > P2point) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private boolean someWon() {
        return P1point >=4 && P1point >= P2point + 2 || P2point >=4 && P2point >= P1point + 2;
    }

    private String handleAllPlayerPointNotLess3() {
        if (P1point > P2point) {
            return "Advantage player1";
        }
        return "Advantage player2";
    }

    private boolean onePlayerIsZero() {
        return P1point == 0 || P2point == 0;
    }

    private String handleSameScore() {
        switch (P1point) {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            case 3:
            default:
                return "Deuce";
        }
    }


    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}