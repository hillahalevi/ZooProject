package commands.SpecificCommands;

import databases.DaysPlanner;

import java.util.List;

public class GetSpecificDayCommand extends SpecificCommand {
    @Override
    public void doCommand(List<String> details) throws Exception {
        System.out.println(DaysPlanner.getInstance().getSpecificDay(details.get(0)));
    }

    @Override
    public String getDescription() {
        return "Get specific Day : userName--Get-specific-day--DAY_WANTED";
    }
}
