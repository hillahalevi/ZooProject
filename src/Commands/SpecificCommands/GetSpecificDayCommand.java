package Commands.SpecificCommands;

import DataBases.DaysPlanner;

import java.util.List;

public class GetSpecificDayCommand extends SpecificCommand {
    @Override
    public void doCommand(List<String> details) throws Exception {
        System.out.println(DaysPlanner.getInstance().getSpecificDay(details.get(0)));
    }

    @Override
    public String getDescription() {
        return "Get specific Day : Get-specific-day--userName--DAY_WANTED";
    }
}
