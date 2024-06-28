// Path: /src/main/java/com/example/BiathlonStandings.java
package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BiathlonStandings {

    public List<Athlete> parseCSV(String csvData) {
        List<Athlete> athletes = new ArrayList<>();
        Scanner scanner = new Scanner(csvData);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            int number = Integer.parseInt(parts[0]);
            String name = parts[1];
            String countryCode = parts[2];
            SkiTime skiTimeResult = SkiTime.parse(parts[3]);
            String firstShootingRange = parts[4];
            String secondShootingRange = parts[5];
            String thirdShootingRange = parts[6];
            athletes.add(new Athlete(number, name, countryCode, skiTimeResult, firstShootingRange, secondShootingRange, thirdShootingRange));
        }
        scanner.close();
        return athletes;
    }

    public List<Athlete> calculateStandings(List<Athlete> athletes) {
        Collections.sort(athletes);
        return athletes;
    }

    public static void main(String[] args) {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                         "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                         "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";
        
        BiathlonStandings standings = new BiathlonStandings();
        List<Athlete> athletes = standings.parseCSV(csvData);
        List<Athlete> finalStandings = standings.calculateStandings(athletes);

        System.out.println("Winner - " + finalStandings.get(0));
        System.out.println("Runner-up - " + finalStandings.get(1));
        System.out.println("Third Place - " + finalStandings.get(2));
    }
}
