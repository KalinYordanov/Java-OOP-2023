package FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teamsByName = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandsParts = command.split(";");
            String commandName = commandsParts[0];
            switch (commandName) {
                case "Team":
                    handleAddTeam(commandsParts[1], teamsByName);
                    break;
                case "Add":
                    handleAddPlayer(commandsParts[1], commandsParts[2], commandsParts[3]
                            , commandsParts[4], commandsParts[5], commandsParts[6], commandsParts[7]
                            , teamsByName);
                    break;
                case "Remove":
                    handleRemovePlayer(commandsParts[1], commandsParts[2], teamsByName);
                    break;
                case "Rating":
                    handleRating(commandsParts[1], teamsByName);
                    break;
                default:
                    throw new IllegalStateException("Unknown command " + commandName);
            }


            command = scanner.nextLine();
        }
    }

    private static void handleRating(String teamName, Map<String, Team> teamsByName) {
        Team team = getTeamOrPrintNotFound(teamsByName, teamName);
        if (team == null) return;

        System.out.printf("%s - %d%n", teamName, Math.round(teamsByName.get(teamName).getRating()));

    }

    private static void handleRemovePlayer(String teamName, String playerName, Map<String, Team> teamsByName) {
        Team team = getTeamOrPrintNotFound(teamsByName, teamName);
        if (team == null) return;
        try {
            team.removePlayer(playerName);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }

    private static Team getTeamOrPrintNotFound(Map<String, Team> teamsByName, String teamName) {
        Team team = teamsByName.get(teamName);
        if (team == null) {
            System.out.println("Team " + teamName + " does not exist.");
            return null;
        }
        return team;
    }


    private static void handleAddPlayer(String teamName, String playerName, String enduranceStr, String sprintStr, String dribbleStr, String passingStr, String shootingStr, Map<String, Team> teamsByName) {
        Team team = getTeamOrPrintNotFound(teamsByName, teamName);
        if (team == null) return;
        Player player;
        try {
            player = new Player(playerName,
                    Integer.parseInt(enduranceStr),
                    Integer.parseInt(sprintStr),
                    Integer.parseInt(dribbleStr),
                    Integer.parseInt(passingStr),
                    Integer.parseInt(shootingStr));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        team.addPlayer(player);
    }

    private static void handleAddTeam(String teamName, Map<String, Team> teamsByName) {
        try {
            Team team = new Team(teamName);
            teamsByName.put(team.getName(), team);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
