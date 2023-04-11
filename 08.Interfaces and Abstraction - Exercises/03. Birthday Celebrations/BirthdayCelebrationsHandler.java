package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;

public class BirthdayCelebrationsHandler extends CommandHandler {
    private List<Birthable> birthable;

    public BirthdayCelebrationsHandler(String endCommand) {
        super(endCommand);
        birthable = new ArrayList<>();
    }

    @Override
    protected void processNonEndCommand(String command) {
        String[] parameters = command.split("\\s+");
        Birthable b;
        switch (parameters[0]) {
            case "Citizen":
                b = new Citizen(parameters[1], Integer.parseInt(parameters[2]), parameters[3], parameters[4]);
                break;
            case "Pet":
                b = new Pet(parameters[1], parameters[2]);
                break;
            case "Robot":
                b = null;
                new Robot(parameters[1], parameters[2]);
                break;
            default:
                throw new IllegalStateException("Unknown command: " + command);
        }
        if (b != null) {
            birthable.add(b);
        }

    }

    public List<Birthable> getAllBirthable() {
        return birthable;
    }
}
