package Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenSecondPlayerWin() {
        Player petya = new Player(1, "Петя", 120);
        Player vasya = new Player(2, "Вася", 100);
        Game game = new Game();

        game.register(petya);
        game.register(vasya);
        int actual = game.round("Вася", "Петя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenFirstPlayerWin() {
        Player vasya = new Player(1, "Вася", 120);
        Player petya = new Player(2, "Петя", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenStrengthsEqual() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenFirstPlayerNotRegistered() {
        Player vasya = new Player(1, "Вася", 100);
        Game game = new Game();

        game.register(vasya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Жора", "Вася")
        );
    }
    @Test
    public void testWhenSecondPlayerNotRegistered() {
        Player vasya = new Player(1, "Вася", 100);
        Game game = new Game();

        game.register(vasya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вася", "Жора")
        );
    }

}