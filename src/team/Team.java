package team;

import players.Player;

import java.util.ArrayList;
import java.util.Comparator;

public class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    private TeamScore teamScore;
    private ArrayList<T> players;

    public Team(String name) {
        this.teamScore = new TeamScore();
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumPlayers() {
        return this.players.size();
    }

    public boolean addPlayer(T player) {
        if (player == null) {
            System.out.println("You did not pass any player");
            return false;
        }

        boolean result = false;
        if (this.players.contains(player)) {
            System.out.println("Player is already in the team");
        } else {
            this.players.add(player);
            result = true;
        }
        return result;
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {

        String message;

        if (ourScore > theirScore) {
            teamScore.addWon(1);
            message = " beat ";
        } else if (ourScore == theirScore) {
            teamScore.addTied(1);
            message = " drew with ";

        } else {
            teamScore.addLost(1);
            message = " lost to ";
        }
        teamScore.addPlayed(1);
        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (teamScore.getWon() * 2) + teamScore.getTied();
    }


    //    return -1 when this.team is higher in ranking than team 1 otherwise
    @Override
    public int compareTo(Team<T> team) {
        if (team == null) {
            return -1;
        }
        int compare = 0;
        if (this.ranking() > team.ranking()) {
            compare = -1;
        } else if (this.ranking() < team.ranking()) {
            compare = 1;
        }
        return compare;
    }
}
