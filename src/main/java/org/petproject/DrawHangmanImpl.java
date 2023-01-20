package org.petproject;

public class DrawHangmanImpl implements DrawHangman {

    @Override
    public void drawHangman(int mistakesCounter) {
        if (mistakesCounter == 0) {
            drawEmptyHangman();
        }
        if (mistakesCounter == 1) {
            drawHead();
        }
        if (mistakesCounter == 2) {
            drawBody();
        }
        if (mistakesCounter == 3) {
            drawLeftArm();
        }
        if (mistakesCounter == 4) {
            drawRightArm();
        }
        if (mistakesCounter == 5) {
            drawLeftLeg();
        }
        if (mistakesCounter == 6) {
            drawRightLeg();
        }
    }

    private void drawEmptyHangman() {
        System.out.println("=======================");
        System.out.println(" ||              |     ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
    }

    private void drawHead() {
        System.out.println("=======================");
        System.out.println(" ||              |     ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
    }

    private void drawBody() {
        System.out.println("=======================");
        System.out.println(" ||              |     ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||              |     ");
        System.out.println(" ||              |     ");
        System.out.println(" ||              |     ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
    }

    private void drawLeftArm() {
        System.out.println("=======================");
        System.out.println(" ||              |     ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||              |     ");
        System.out.println(" ||          ----|     ");
        System.out.println(" ||              |     ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
    }

    private void drawRightArm() {
        System.out.println("=======================");
        System.out.println(" ||              |     ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||              |     ");
        System.out.println(" ||          ----|---- ");
        System.out.println(" ||              |     ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
    }

    private void drawLeftLeg() {
        System.out.println("=======================");
        System.out.println(" ||              |     ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||              |     ");
        System.out.println(" ||          ----|---- ");
        System.out.println(" ||              |     ");
        System.out.println(" ||             /      ");
        System.out.println(" ||            /       ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
    }

    private void drawRightLeg() {
        System.out.println("=======================");
        System.out.println(" ||              |     ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||             ***    ");
        System.out.println(" ||              |     ");
        System.out.println(" ||          ----|---- ");
        System.out.println(" ||              |     ");
        System.out.println(" ||             / \\   ");
        System.out.println(" ||            /   \\  ");
        System.out.println(" ||                    ");
        System.out.println(" ||                    ");
    }
}
