package com.bvan.jc.employee;

/**
 * @author bvanchuhov
 */
public enum Position {
    SECRETARY(0);

    private final int number;

    public static Position ofNumber(int number) {
        for (Position position : Position.values()) {
            if (position.number == number) {
                return position;
            }
        }
        return null;
    }

    Position(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
