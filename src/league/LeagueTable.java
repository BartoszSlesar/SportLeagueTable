package league;

import team.Team;

import java.util.LinkedList;

public class LeagueTable<T extends Team> {
    private LinkedList<T> teams;

    public LeagueTable() {
        teams = new LinkedList<>();
    }

    public int getNumTeams() {
        return this.teams.size();
    }
}
