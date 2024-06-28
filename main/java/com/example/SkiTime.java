// Path: /src/main/java/com/example/SkiTime.java
package com.example;

public class SkiTime {
    private int minutes;
    private int seconds;

    public SkiTime(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int toSeconds() {
        return minutes * 60 + seconds;
    }

    public static SkiTime parse(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return new SkiTime(minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", minutes, seconds);
    }
}
