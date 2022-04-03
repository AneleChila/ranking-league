package com.span.reader;

import com.span.service.GameResultProcessor;

import java.util.Scanner;

public class StandardInputReader {

    private GameResultProcessor gameResultProcessor;
    private Scanner scanner;

    public StandardInputReader(GameResultProcessor gameResultProcessor) {
        this.gameResultProcessor = gameResultProcessor;
        scanner = new Scanner(System.in);
    }

    public void readInputGames(int numberOfLines) {
        String data = scanner.nextLine();
        gameResultProcessor.process(data.substring(
                0, data.indexOf(",")),
                data.substring(data.indexOf(",") + 2)
        );

        if(numberOfLines <= 0) {
            gameResultProcessor.getTableResults();
        }
    }

    public String readInputOption() {
        System.out.println("Hi, would you like to input data using a file(1) or standard-input(2) ? \n(reply 1 or 2)");
        return scanner.nextLine();
    }

    public String readNumberOfLines() {
        System.out.println("Enter number of lines :");
        return scanner.nextLine();
    }
}
