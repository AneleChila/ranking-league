package com.span.controller;


import com.span.model.LeagueTable;
import com.span.reader.FileInputReader;
import com.span.reader.StandardInputReader;
import com.span.service.GameResultProcessor;

public class GameInputController {

    private FileInputReader fileInputReader;
    private StandardInputReader standardInputReader;

    public GameInputController() {
        LeagueTable leagueTable = new LeagueTable();
        GameResultProcessor gameResultProcessor = new GameResultProcessor(leagueTable);
        standardInputReader = new StandardInputReader(gameResultProcessor);
        fileInputReader = new FileInputReader(gameResultProcessor);
    }

    public void readInput() {
        int inputOption = Integer.parseInt(standardInputReader.readInputOption());

        switch (inputOption) {
            case 1 :
                fileInputReader.readFile(fileInputReader.getFileName());
            case 2 :
                int numberOfLines = Integer.parseInt(standardInputReader.readNumberOfLines());
                System.out.println("Enter matches :");
                while (numberOfLines >= 1) {
                    standardInputReader.readInputGames(numberOfLines);
                    numberOfLines--;
                }
        }
    }

}
