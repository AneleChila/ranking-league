package Reader;

import com.span.model.LeagueTable;
import com.span.reader.FileInputReader;
import com.span.reader.StandardInputReader;
import com.span.service.GameResultProcessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class StandardInputReaderTest {

    private StandardInputReader inTestStandardInputReader;

    private GameResultProcessor gameResultProcessor;
    private Scanner scanner;



    @Before
    public void setUp() {
        scanner = mock(Scanner.class);
        gameResultProcessor = mock(GameResultProcessor.class);
        inTestStandardInputReader = new StandardInputReader(gameResultProcessor);
    }

    @Test
    public void mustReadInputGames() {
        String input = "b 9, k 7\n" +
                "h 8, o 8\n" +
                "j 5, k 5\n" +
                "h 4, i 2\n" +
                "b 9, k 7\n" +
                "n 8, o 8\n" +
                "j 5, k 5\n" +
                "h 4, p 2\n" +
                "b 9, k 7\n" +
                "h 8, z 8\n" +
                "j 5, k 5\n" +
                "h 4, u 2";

       when(scanner.nextLine()).thenReturn(input);
       inTestStandardInputReader.readInputGames();



        verify(gameResultProcessor).getTableResults();
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(gameResultProcessor, times(12)).process(argumentCaptor.capture(), argumentCaptor.capture());
        List<String> captured = argumentCaptor.getAllValues();
        Assertions.assertEquals(captured.size(), 24);
    }


    @Test
    public void mustReadInputOption() {

    }

    @Test
    public void mustReadNumberOfLines() {

    }

}
