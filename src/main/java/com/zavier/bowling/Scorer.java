package com.zavier.bowling;

public class Scorer {
    private int ball;
    private int[] throwArray = new int[21];
    private int currentThrow;
    
    public void addThrow(int pins) {
        throwArray[currentThrow++] = pins;
    }
    
    public int scoreForFrame(int theFrame) {
        ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            if (isStrike()) {
                score += 10 + getNextTwoBalls();
                ball++;
            } else if (isSpare()){
                score += 10 + getNextBall();
                ball += 2;
            } else {
                score += getTwoBallsInFrame();
                ball += 2;
            }
        }
        return score;
    }

    private int getNextTwoBalls() {
        return throwArray[ball + 1] + throwArray[ball + 2];
    }

    private boolean isStrike() {
        return throwArray[ball] == 10;
    }

    private int getTwoBallsInFrame() {
        return throwArray[ball] + throwArray[ball + 1];
    }

    private boolean isSpare() {
        return throwArray[ball] + throwArray[ball + 1] == 10;
    }

    private int getNextBall() {
        return throwArray[ball + 2];
    }
}
