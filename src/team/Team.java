package team;

import players.Player;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> players;

    public Team(String name) {
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

//    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
//
//        String message;
//
//        if(ourScore > theirScore) {
//            won++;
//            message = " beat ";
//        } else if(ourScore == theirScore) {
//            tied++;
//            message = " drew with ";
//
//        } else {
//            lost++;
//            message = " lost to ";
//        }
//        played++;
//        if(opponent != null) {
//            System.out.println(this.getName() + message + opponent.getName());
//            opponent.matchResult(null, theirScore, ourScore);
//        }
//    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> o) {
        return 0;
    }
}
