package com.zavier.bowling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    /**
     * 两次投球无补中
     */
    @Test
    public void testTwoThrowsNoMark() {
        game.add(5);
        game.add(4);
        Assert.assertEquals(9, game.getScore());
        Assert.assertEquals(2, game.getCurrentFrame());
    }

    /**
     * 四次投球无补中
     */
    @Test
    public void testFourThrowsNoMark() {
        game.add(5);
        game.add(4);
        game.add(7);
        game.add(2);
        Assert.assertEquals(18, game.getScore());
        Assert.assertEquals(9, game.getScoreForFrame(1));
        Assert.assertEquals(18, game.getScoreForFrame(2));
        Assert.assertEquals(3, game.getCurrentFrame());
    }

    /**
     * 补中
     */
    @Test
    public void testSimpleSpare() {
        game.add(3);
        game.add(7);
        game.add(3);
        Assert.assertEquals(13, game.getScoreForFrame(1));
        Assert.assertEquals(2, game.getCurrentFrame());
    }

    @Test
    public void testSimpleFrameAfterSpare() {
        game.add(3);
        game.add(7);
        game.add(3);
        game.add(2);
        Assert.assertEquals(13, game.getScoreForFrame(1));
        Assert.assertEquals(18, game.getScoreForFrame(2));
        Assert.assertEquals(18, game.getScore());
        Assert.assertEquals(3, game.getCurrentFrame());
    }

    /**
     * 全中
     */
    @Test
    public void testSimpleStrike() {
        game.add(10);
        game.add(3);
        game.add(6);
        Assert.assertEquals(19, game.getScoreForFrame(1));
        Assert.assertEquals(28, game.getScore());
        Assert.assertEquals(3, game.getCurrentFrame());
    }

    @Test
    public void testPerfectGame() {
        for (int i = 0; i < 12; i++) {
            game.add(10);
        }
        Assert.assertEquals(300, game.getScore());
        Assert.assertEquals(10, game.getCurrentFrame());
    }

    @Test
    public void testEndOfArray() {
        for (int i = 0; i < 9; i++) {
            game.add(0);
            game.add(0);
        }
        game.add(2);
        game.add(8);
        game.add(10);
        Assert.assertEquals(20, game.getScore());
    }

    @Test
    public void testSampleGame() {
        game.add(1);
        game.add(4);
        game.add(4);
        game.add(5);
        game.add(6);
        game.add(4);
        game.add(5);
        game.add(5);
        game.add(10);
        game.add(0);
        game.add(1);
        game.add(7);
        game.add(3);
        game.add(6);
        game.add(4);
        game.add(10);
        game.add(2);
        game.add(8);
        game.add(6);
        Assert.assertEquals(133, game.getScore());
    }

    @Test
    public void testHeartBreak() {
        for (int i = 0; i < 11; i++) {
            game.add(10);
        }
        game.add(9);
        Assert.assertEquals(299, game.getScore());
    }

    @Test
    public void testTenthFrameSpare() {
        for (int i = 0; i < 9; i++) {
            game.add(10);
        }
        game.add(9);
        game.add(1);
        game.add(1);
        Assert.assertEquals(270, game.getScore());
    }
}
