import java.util.*;
interface Command{
    void execute();
}
class RideService{
    public void requestRide(String passenger,String srcloc,String destloc){
        System.out.println("Customer "+passenger+" requested ride from "+srcloc+" to "+destloc);
    }
    public void cancelRide(String passenger){
        System.out.println("Cancel ride for "+passenger);
    }
}
class RideRequestCommand implements Command{
    private RideService reciever;
    private String passenger;
    private String srcloc;
    private String destloc;
    public RideRequestCommand(RideService reciever,String passenger,String srcloc,String destloc){
        this.reciever=reciever;
        this.passenger=passenger;
        this.srcloc=srcloc;
        this.destloc=destloc;
    }
    public void execute(){
        reciever.requestRide(passenger,srcloc,destloc);
    }
}
class CancelRideCommand implements Command{
    private RideService reciever;
    private String passenger;
    public CancelRideCommand(RideService reciever,String passenger){
        this.reciever=reciever;
        this.passenger=passenger;
    }
    public void execute(){
        reciever.cancelRide(passenger);
    }
}
class RideInvoker{
    public void processRequest(Command command){
        command.execute();
    }
}
public class UberRideDemo{
    public static void main(String args[]){
        RideService reciever=new RideService();
        RideInvoker rideInvoker=new RideInvoker();
        Command request1=new RideRequestCommand(reciever,"Kiranmai","ong","adk");
        Command request2=new RideRequestCommand(reciever,"Haneesh","adk","nrt");
        Command cancel=new CancelRideCommand(reciever,"haneesh");
        rideInvoker.processRequest(request1);
        rideInvoker.processRequest(request2);
        rideInvoker.processRequest(cancel);
    }
}