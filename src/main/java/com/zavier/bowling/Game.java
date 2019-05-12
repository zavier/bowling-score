package com.zavier.bowling;

public class Game {
    private int currentFrame = 1;
    private boolean isFirstThrow = true;

    private Scorer scorer = new Scorer();

    public int getScore() {
        return getScoreForFrame(getCurrentFrame());
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void add(int pins) {
        scorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (isLastBallInFrame(pins)) {
            advanceFrame();
        } else {
            isFirstThrow = false;
        }
    }

    private boolean isLastBallInFrame(int pins) {
        return isStrike(pins) || (!isFirstThrow);
    }

    private boolean isStrike(int pins) {
        return isFirstThrow && pins == 10;
    }

    private void advanceFrame() {
        currentFrame++;
        if (currentFrame > 10) {
            currentFrame = 10;
        }
    }

    public int getScoreForFrame(int theFrame) {
        return scorer.scoreForFrame(theFrame);
    }

}
