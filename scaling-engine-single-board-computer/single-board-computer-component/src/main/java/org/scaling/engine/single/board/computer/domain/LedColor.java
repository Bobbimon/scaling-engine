package org.scaling.engine.single.board.computer.domain;

public enum LedColor {

    BLUE(0, 0, 255),
    GREEN(0, 255, 0),
    RED(255,0,0);

    private int blue;
    private int green;
    private int red;

    LedColor(int red, int green, int blue) {
        this.blue = blue;
        this.green = green;
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

    public int[] valueOf() {
        int[] RGB = new int[3];
        RGB[0] = red;
        RGB[1] = green;
        RGB[2] = blue;
        return RGB;
    }


}
