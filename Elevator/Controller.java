import java.util.concurrent.Semaphore;

public class Controller {
//    public static Semaphore elevator=new Semaphore(10);

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //initiation
        Elevator elevator=new Elevator(500, true,1);

        for (int i = 1; i < 11; i++) {
            Passenger passenger= new Passenger(i,1,elevator);
            passenger.start();
        }
        elevator.start();

    }

}



