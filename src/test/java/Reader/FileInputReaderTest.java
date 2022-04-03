package Reader;

import com.span.reader.FileInputReader;
import com.span.processor.GameResultProcessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.mockito.Mockito.*;

public class FileInputReaderTest {

    private FileInputReader fileInputReaderTest;

    private GameResultProcessor gameResultProcessor;


    @Before
    public void setUp() {
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
