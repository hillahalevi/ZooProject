package Commands.BasicCommand;

import DataBases.UsersDataBase;

import java.util.List;

public class GetUsersCommand extends BaseCommand {
    @Override
    protected String getDescription() {
        return "retrieve all registered users";
    }

    @Override
    public void execute(List<String> details) throws Exception {
        System.out.println(UsersDataBase.getInstance().getUsers());

    }


}
