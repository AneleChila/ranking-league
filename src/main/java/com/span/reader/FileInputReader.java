package com.span.reader;

import com.span.service.GameResultProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputReader {

    private GameResultProcessor gameResultProcessor;

    public FileInputReader(GameResultProcessor gameResultProcessor) {
        this.gameResultProcessor = gameResultProcessor;
    }

    public void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                gameResultProcessor.process(data.substring(
                        0, data.indexOf(",")),
                        data.substring(data.indexOf(",") + 2)
                );
            }
            gameResultProcessor.getTableResults();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path :");
        return scanner.nextLine();
    }
}
