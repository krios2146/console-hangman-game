package org.petproject;

public class DrawHangmanImpl implements DrawHangman {

    private int mistakesCounter = 0;

    @Override
    public void drawHangman() {
        if (mistakesCounter == 0) {
            drawEmptyHangman();
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
