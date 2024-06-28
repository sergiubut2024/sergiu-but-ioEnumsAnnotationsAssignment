// Path: /src/main/java/com/example/Athlete.java
package com.example;

public class Athlete implements Comparable<Athlete> {
    private int number;
    private String name;
    private String countryCode;
    private SkiTime skiTimeResult;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;

    public Athlete(int number, String name, String countryCode, SkiTime skiTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    public int calculateTotalTime() {
        int penaltySeconds = calculatePenalty(firstShootingRange) + calculatePenalty(secondShootingRange) + calculatePenalty(thirdShootingRange);
        return skiTimeResult.toSeconds() + penaltySeconds;
    }

    private int calculatePenalty(String shootingRange) {
        int penalty = 0;
        for (char c : shootingRange.toCharArray()) {
            if (c == 'o') {
                penalty += 10;
            }
        }
        return penalty;
    }

    @Override
    public int compareTo(Athlete other) {
        return Integer.compare(this.calculateTotalTime(), other.calculateTotalTime());
    }

    @Override
    public String toString() {
        return name + " " + skiTimeResult + " (" + skiTimeResult + " + " + calculateTotalTime() + ")";
    }
}
