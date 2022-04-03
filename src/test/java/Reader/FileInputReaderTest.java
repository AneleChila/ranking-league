package Reader;

import com.span.model.LeagueTable;
import com.span.reader.FileInputReader;
import com.span.reader.StandardInputReader;
import com.span.service.GameResultProcessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class FileInputReaderTest {

    private FileInputReader fileInputReaderTest;

    private LeagueTable leagueTable;
    private GameResultProcessor gameResultProcessor = new GameResultProcessor(leagueTable);


    @Before
    public void setUp() {
        leagueTable = mock(LeagueTable.class);
        gameResultProcessor = mock(GameResultProcessor.class);
        fileInputReaderTest = new FileInputReader(gameResultProcessor);
    }

    @Test
    public void mustReadInputGames() {
        fileInputReaderTest.readFile("/Users/anelechila/ranking-league/src/test/java/InputData");

        verify(gameResultProcessor).getTableResults();
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(gameResultProcessor, times(12)).process(argumentCaptor.capture(), argumentCaptor.capture());
        List<String> captured = argumentCaptor.getAllValues();
        Assertions.assertEquals(captured.size(), 24);
    }
}
