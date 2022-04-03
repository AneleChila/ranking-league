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

    private LeagueTable leagueTable;
    private GameResultProcessor gameResultProcessor = new GameResultProcessor(leagueTable);


    @Before
    public void setUp() {
        leagueTable = mock(LeagueTable.class);
        gameResultProcessor = mock(GameResultProcessor.class);
        inTestStandardInputReader = new StandardInputReader(gameResultProcessor);
    }

    @Test
    public void mustReadInputGames() {
        inTestStandardInputReader.readInputGames(5);



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
