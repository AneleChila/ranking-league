package com.span.reader;

import com.span.processor.GameResultProcessor;

import java.util.Scanner;

public class StandardInputReader {

    private GameResultProcessor gameResultProcessor;
    private Scanner scanner;

    public StandardInputReader(GameResultProcessor gameResultProcessor) {
        this.gameResultProcessor = gameResultProcessor;
        scanner = new Scanner(System.in);
    }

    public void readInputGames() {
        System.out.println("Enter matches :");
        String line = scanner.nextLine();
        do {
            gameResultProcessor.process(line.substring(
                    0, line.indexOf(",")),
                    line.substring(line.indexOf(",") + 2)
            );
            line = scanner.nextLine();
        } while (!line.equals(""));

        gameResultProcessor.getTableResults();
    }

    public int readInputOption() {
        System.out.println("Hi, would you like to input data using a file(1) or standard-input(2) ? \n(reply 1 or 2)");
        return Integer.parseInt(scanner.nextLine());
    }
}
