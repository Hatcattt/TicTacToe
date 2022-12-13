package tictactoe;

import dev.hatcattt.tictactoe.gui.GameLevelConfiguration;
import dev.hatcattt.tictactoe.level.GameLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class GameLevelConfigurationTest {

    @Test
    void testWhenUserChooseTheNormalLevel(){
        var level = GameLevel.NORMAL;
        System.out.println("Choose " + level);

        var input = GameLevelConfiguration.setAGameLevel();
        assertSame(level, input);
    }

    @Test
    void testWhenUserChooseTheHardLevel(){
        var level = GameLevel.HARD;
        System.out.println("Choose " + level);

        var input = GameLevelConfiguration.setAGameLevel();
        assertSame(level, input);
    }

    @Test
    void testWhenUserChooseTheInsaneLevel(){
        var level = GameLevel.INSANE;
        System.out.println("Choose " + level);

        var input = GameLevelConfiguration.setAGameLevel();
        assertSame(level, input);
    }
}
