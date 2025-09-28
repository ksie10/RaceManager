package model;

import java.util.*;

public class RaceSystem {
    private List<User> users = new ArrayList<>();
    private List<Race> availableRaces = new ArrayList<>();
    private List<RaceResult> raceHistory = new ArrayList<>();

    private static int nextRaceId = 0;
    private static final Map<String, Race> races = new HashMap<>();



    public void registerUser(User user) { users.add(user); }

    public List<Race> findRaceByDate(Date d) {
        // TODO: filter by date
        return availableRaces;
    }

    public void upgradeCategory(Racer racer) {
            if (racer == null) {
                throw new IllegalArgumentException("Racer cannot be null");
            }
            
            int currentLevel = racer.getCatLevel();
            int maxLevel = 5; // Assuming categories 1-5 (1 being beginner, 5 being expert)
            
            if (currentLevel < maxLevel) {
                racer.setCatLevel(currentLevel + 1);
                System.out.println("Racer " + racer.getName() + " upgraded from category " 
                                 + currentLevel + " to category " + racer.getCatLevel());
            } else {
                System.out.println("Racer " + racer.getName() + " is already at the highest category level (" 
                                 + maxLevel + ")");
            }
        }




    public Race createRace(Date date, String type, double miles, String route, boolean official, int limit, Date lastRegDate, int catRequired) {
        String id = "R" + (++nextRaceId);
        Race race = new Race(id);
        race.setRaceDate(date);
        race.setType(type);
        race.setMiles(miles);
        race.setRoute(route);
        race.setOfficialRace(official);
        race.setParticipantLimit(limit);
        race.setLastRegistrationDate(lastRegDate);
        race.setCatRequired(catRequired);

        races.put(id, race);

        // Observer hook (simplified for now)
        System.out.println("Notification: Race created -> " + id);

        return race;
    }

    public List<Race> getAllRaces() {
        return new ArrayList<>(races.values());
    }






}

