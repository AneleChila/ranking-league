package service;

import com.span.model.LeagueTable;
import com.span.service.GameResultProcessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class GameResultProcessorTest {

    private LeagueTable leagueTable;
    private GameResultProcessor inTestGameResultProcessor;

    @Before
    public void setUp() {
        leagueTable = new LeagueTable();
        inTestGameResultProcessor = new GameResultProcessor(leagueTable);
    }

    @Test
    public void shouldAddAllScoresCorrectly() {
        inTestGameResultProcessor.process("m 9", "l 9");
        inTestGameResultProcessor.process("k 4", "o 8");
        inTestGameResultProcessor.process("m 8", "p 7");

        assertEquals(4, (int) leagueTable.get("m"));
        assertEquals(0, (int) leagueTable.get("p"));
        assertEquals(0, (int) leagueTable.get("k"));
        assertEquals(3, (int) leagueTable.get("o"));
        assertEquals(1, (int) leagueTable.get("l"));
    }

    @Test
    public void shouldThrowErrorOnIncorrectScore() {
        Assertions.assertThrows(NumberFormatException.class, () -> inTestGameResultProcessor.process("m f", "l 9"));
    }

    @Test
    public void shouldPrintResults() {
        inTestGameResultProcessor.process("m 9", "l 9");
        inTestGameResultProcessor.process("k 4", "o 8");
        inTestGameResultProcessor.process("m 8", "p 7");
        inTestGameResultProcessor.process("m 9", "l 9");

        inTestGameResultProcessor.getTableResults();
    }


}
