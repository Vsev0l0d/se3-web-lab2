package models;

public class Entry {
    private int X;
    private double Y;
    private int R;
    private boolean result;

    public Entry(int x, double y, int r, boolean result) {
        X = x;
        Y = y;
        R = r;
        this.result = result;
    }

    public int getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public int getR() {
        return R;
    }

    public boolean isResult() {
        return result;
    }
}