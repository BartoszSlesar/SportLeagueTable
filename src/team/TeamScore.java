package team;

public class TeamScore {
    private int played;
    private int won;
    private int lost;
    private int tied;

    public TeamScore() {
        played = 0;
        won = 0;
        lost = 0;
        tied = 0;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getTied() {
        return tied;
    }

    public void addPlayed(int played) {
        this.played += played;
    }

    public void addWon(int won) {
        this.won += won;
    }

    public void addLost(int lost) {
        this.lost += lost;
    }

    public void addTied(int tied) {
        this.tied += tied;
    }
}
