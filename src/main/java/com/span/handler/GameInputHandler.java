package com.span.handler;


import com.span.model.LeagueTable;
import com.span.reader.FileInputReader;
import com.span.reader.StandardInputReader;
import com.span.processor.GameResultProcessor;

public class GameInputHandler {

    private FileInputReader fileInputReader;
    private StandardInputReader standardInputReader;

    public GameInputHandler() {
        LeagueTable leagueTable = new LeagueTable();
        GameResultProcessor gameResultProcessor = new GameResultProcessor(leagueTable);
        standardInputReader = new StandardInputReader(gameResultProcessor);
        fileInputReader = new FileInputReader(gameResultProcessor);
    }

    public void readInput() {
        int inputOption = standardInputReader.readInputOption();

        if(inputOption == 1)
            fileInputReader.readFile(fileInputReader.getFileName());
        if(inputOption == 2)
            standardInputReader.readInputGames();
    }
}
