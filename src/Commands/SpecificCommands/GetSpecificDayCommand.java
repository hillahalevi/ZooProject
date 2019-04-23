package Commands.SpecificCommands;

import Commands.InterferingCommands.CommandException;
import DataBases.DaysPlanner;

import java.util.List;

public class GetSpecificDayCommand extends SpecificCommand {
    @Override
    public void doCommand(List<String> details) throws CommandException {
        System.out.println(DaysPlanner.getInstance().getSpecificDay(details.get(0)));
    }

    @Override
    public String getDescription() {
        return "Get specific Day : Get-specific-day--userName--DAY_WANTED";
    }
}
