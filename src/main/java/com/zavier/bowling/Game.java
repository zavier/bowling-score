package com.zavier.bowling;

public class Game {
    private int score;
    private int[] throwss = new int[21];
    private int currentThrow = 0;

    private int currentFrame = 1;
    private boolean isFirstThrow = true;


    public int getScore() {
        return getScoreForFrame(currentFrame);
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void add(int pins) {
        throwss[currentThrow++] = pins;
        score += pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (isFirstThrow) {
            if (pins == 10) {
                currentFrame++;
            } else {
                isFirstThrow = false;
            }
        } else {
            isFirstThrow = true;
            currentFrame++;
        }

        if (currentFrame > 10) {
            currentFrame = 10;
        }
    }

    public int getScoreForFrame(int theFrame) {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            int firstThrow = this.throwss[ball++];

            if (firstThrow == 10) {
                score += 10 + throwss[ball] + throwss[ball + 1];
            } else {
                int secondThrow = this.throwss[ball++];
                int frameScore = firstThrow + secondThrow;
                if (frameScore == 10) {
                    score += frameScore + throwss[ball];
                } else {
                    score += frameScore;
                }
            }
        }
        return score;
    }
}
