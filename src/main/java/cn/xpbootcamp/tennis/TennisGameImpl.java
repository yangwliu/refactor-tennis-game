package cn.xpbootcamp.tennis;

public class TennisGameImpl implements TennisGame {

    private Player player1;
    private Player player2;
    public TennisGameImpl(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (isSamePoint()) {
            return handleSameScore();
        }

        if (someWon()) {
            return handleSomeWon();
        }

        if (allPlayersPointIsNotLess3(player1.getPoint(), 3, player2.getPoint(), 3)) {
            return handleAllPlayerPointNotLess3();
        }

        return handleAllPlayerPointLess3();
    }

    private boolean allPlayersPointIsNotLess3(int point, int i, int point2, int i2) {
        return point >= i && point2 >= i2;
    }

    private boolean isSamePoint() {
        return player1.getPoint() == player2.getPoint();
    }

    private String handleAllPlayerPointLess3() {
        String player1Score = getPointText(player1.getPoint());
        String player2Score = getPointText(player2.getPoint());
        return player1Score + "-" + player2Score;
    }

    private String handleSomeWon() {
        if (player1.getPoint() > player2.getPoint()) {
            return "Win for " + player1.getName();
        }
        return "Win for " + player2.getName();
    }

    private boolean someWon() {
        int player1Score = player1.getPoint();
        int player2Score = player2.getPoint();
        return player1Score >= 4 && player1Score >= player2Score + 2 || player2Score >=4 && player2Score >= player1Score + 2;
    }

    private String handleAllPlayerPointNotLess3() {
        if (player1.getPoint() > player2.getPoint()) {
            return "Advantage " + player1.getName();
        }
        return "Advantage " + player2.getName();
    }

    private String handleSameScore() {
        String pointText = getPointText(player1.getPoint());
        if ("".equals(pointText) || "Forty".equals(pointText)) {
            return "Deuce";
        }
        return pointText + "-All";
    }

    private String getPointText(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default:
                return "";
        }
    }

}