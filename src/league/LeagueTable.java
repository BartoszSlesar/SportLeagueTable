package league;

import team.Team;

import java.util.*;

public class LeagueTable<T extends Team> {
    private String name;
    private ArrayList<T> teams;

    public LeagueTable(String name) {
        this.name = name;
        teams = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumTeams() {
        return this.teams.size();
    }

    public boolean addTeam(T team) {

        boolean result = true;
        if (team == null || this.teams.contains(team)) {
            result = false;
        } else {
            teams.add(team);
        }
        return true;
    }

    public void printLeagueTable() {
        Collections.sort(teams, new TeamComparator());
        for (T team : this.teams) {
            System.out.println(team.getName() + ": " + team.ranking());
        }
    }



    private class TeamComparator implements Comparator<T> {


        @Override
        public int compare(T team1, T team2) {
            return team1.compareTo(team2);
        }
    }

}
