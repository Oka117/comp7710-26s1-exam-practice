package hashing.Q1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardGameTest {
    @Test
    public void testEqualsSymmetric() {
        BoardGame g1 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        BoardGame g2 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        assertEquals(g1, g2);
        assertEquals(g2, g1);
    }

    @Test
    public void testEqualsDifferentName() {
        BoardGame g1 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        BoardGame g2 =
                new BoardGame("Risk", BoardGame.Genre.STRATEGY, 1995);

        assertNotEquals(g1, g2);
    }

    @Test
    public void testEqualsDifferentGenre() {
        BoardGame g1 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        BoardGame g2 =
                new BoardGame("Catan", BoardGame.Genre.CLASSIC, 1995);

        assertNotEquals(g1, g2);
    }

    @Test
    public void testEqualsDifferentYear() {
        BoardGame g1 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        BoardGame g2 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1996);

        assertNotEquals(g1, g2);
    }

    @Test
    public void testEqualsNull() {
        BoardGame game =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        assertNotEquals(null, game);
    }

    @Test
    public void testEqualsDifferentType() {
        BoardGame game =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        assertNotEquals(game, "Catan");
    }

    @Test
    public void testHashCodeEqualObjects() {
        BoardGame g1 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        BoardGame g2 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        assertEquals(g1.hashCode(), g2.hashCode());
        assertEquals(g1, g2);
    }

    @Test
    public void testHashCodeConsistent() {
        BoardGame game =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        int hash1 = game.hashCode();
        int hash2 = game.hashCode();
        int hash3 = game.hashCode();

        assertEquals(hash1, hash2);
        assertEquals(hash2, hash3);
    }

    @Test
    public void testHashCodeDependsOnName() {
        BoardGame g1 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        BoardGame g2 =
                new BoardGame("Risk", BoardGame.Genre.STRATEGY, 1995);

        assertNotEquals(g1.hashCode(), g2.hashCode());
    }

    @Test
    public void testHashCodeDependsOnGenre() {
        BoardGame g1 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        BoardGame g2 =
                new BoardGame("Catan", BoardGame.Genre.CLASSIC, 1995);

        assertNotEquals(g1.hashCode(), g2.hashCode());
    }

    @Test
    public void testHashCodeDependsOnYear() {
        BoardGame g1 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1995);

        BoardGame g2 =
                new BoardGame("Catan", BoardGame.Genre.STRATEGY, 1996);

        assertNotEquals(g1.hashCode(), g2.hashCode());
    }
}