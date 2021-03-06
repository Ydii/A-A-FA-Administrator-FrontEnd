package servlets;

import commands.Command;
import commands.CreateDepartureCommand;
import commands.DepartureDetailCommand;
import commands.ListDeparturesCommand;
import commands.ListReservationsCommand;
import commands.ReservationDetailCommand;
import commands.ShipDetailCommand;
import commands.StartUpCommand;
import commands.TargetCommand;
import dummy.control.DummyDataRepository;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Thomas Kragsberger
 */
public class Factory {

    private final static Factory instance = new Factory();
    private final Map<String, Command> commands = new HashMap();
    
    private final DummyDataRepository repository = new DummyDataRepository(); //replace repository when database connection is ready

    private Factory(){
        commands.put("start-up", new StartUpCommand("/welcome-page.jsp"));
        commands.put("main", new TargetCommand("/administrator/main-page.jsp"));
        commands.put("view-ship", new ShipDetailCommand("/administrator/ship-detail-page.jsp"));
        commands.put("create-departure", new CreateDepartureCommand("welcome-page.jsp"));
        commands.put("go-to-departure", new ListDeparturesCommand("/administrator/departure-page.jsp"));
        commands.put("view-departure", new DepartureDetailCommand("/administrator/departure-detail-page.jsp"));
        commands.put("go-to-reservations", new TargetCommand("/administrator/reservation-page.jsp"));
        commands.put("view-reservations", new ListReservationsCommand("/administrator/reservation-summary-page.jsp"));
        commands.put("view-reservation", new ReservationDetailCommand("/administrator/reservation-detail-page.jsp"));
    }
    
    public DummyDataRepository getDataRepository() {
        return repository;
    }
    
    public static Factory getInstance(){
        return instance;
    }
    
    public Command getCommand(String commandString, HttpServletRequest request) {
        if (commandString == null) {
            commandString = "start-up";
            
        }
        System.out.println("the command is "+ commandString);
        Command cmd = commands.get(commandString);
        
        return cmd;
    }
}
