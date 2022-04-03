package com.span.model;

public enum Point {

    WIN(3),
    DRAW(1),
    LOSE(0);

    private int point;

    Point(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
