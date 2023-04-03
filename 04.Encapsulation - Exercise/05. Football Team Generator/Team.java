package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        Validators.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        //search player in List and remove
        int toRemoveIndex = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(playerName)) {
                toRemoveIndex = i;
                break;
            }
        }
        if (toRemoveIndex == -1) {
            throw new IllegalStateException("Player " + playerName + " is not in " + getName() + " team.");
        }
        players.remove(toRemoveIndex);
    }

    public double getRating() {
        return Math.round(players.stream().mapToDouble(p -> p.overallSkillLevel()).average().orElse(0));
    }
}
