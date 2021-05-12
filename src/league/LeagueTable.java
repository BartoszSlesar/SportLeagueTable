package league;

import team.Team;

import java.util.*;

public class LeagueTable<T extends Team> {
    private ArrayList<T> teams;

    public LeagueTable() {
        teams = new ArrayList<>();
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
//        Sorting Array to display teams higher in the ranking first, using CompareTo implemented in Teams
        Collections.sort(teams, new TeamComparator());
        for (T team : this.teams) {
            System.out.println(team.getName());
        }
    }

    private class TeamComparator implements Comparator<T> {


        @Override
        public int compare(T team1, T team2) {
            return team1.compareTo(team2);
        }
    }
}
