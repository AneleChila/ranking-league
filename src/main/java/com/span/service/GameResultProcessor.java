package com.span.service;

import com.span.model.LeagueTable;
import com.span.model.Point;

import java.util.*;

public class GameResultProcessor {

    private LeagueTable leagueTable;

    public GameResultProcessor(LeagueTable leagueTable) {
        this.leagueTable = leagueTable;
    }

    public void process(String team1Data, String team2Data) {
        String team1 = team1Data.substring(0, team1Data.indexOf(" "));
        String team2 = team2Data.substring(0, team2Data.indexOf(" "));
        Integer team1Score = Integer.parseInt(team1Data.substring(team1Data.length() - 1 ));
        Integer team2Score = Integer.parseInt(team2Data.substring(team2Data.length() - 1));

        if(team1Score.equals(team2Score)) {
            leagueTable.merge(team1, Point.DRAW.getPoint(), Integer::sum);
            leagueTable.merge(team2, Point.DRAW.getPoint(), Integer::sum);
        } else if (team1Score > team2Score) {
            leagueTable.merge(team1, Point.WIN.getPoint(), Integer::sum);
            leagueTable.merge(team2, Point.LOSE.getPoint(), Integer::sum);
        } else {
            leagueTable.merge(team1, Point.LOSE.getPoint(), Integer::sum);
            leagueTable.merge(team2, Point.WIN.getPoint(), Integer::sum);
        }

    }

    public void getTableResults() {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<>(leagueTable.entrySet());

        // Sort the list using lambda expression
        list.sort(Map.Entry.comparingByValue());

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp
                = new LinkedHashMap<>();
        int counter = 0;

        int previousPoint = 0;
        for(int i = list.size() - 1; i >= 0; i--) {
            if(!list.get(i).getValue().equals(previousPoint)) {
                counter++;
            }
            System.out.println(counter + ". " + list.get(i).getKey() + ", " + list.get(i).getValue() + " pts");
            previousPoint = list.get(i).getValue();
        }
    }
}
