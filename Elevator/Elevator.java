import java.util.concurrent.Semaphore;

public class Elevator extends Thread {
    int floorTime;

    boolean direction; //true is up and false is down

    int currentFloor;

    Semaphore[] floors = new Semaphore[10];


    public Elevator(int floorTime,boolean direction,int currentFloor) {
        this.floorTime=floorTime;
        this.direction=direction;
        this.currentFloor=currentFloor;
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Semaphore(10);
        }
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true) {

//            while(direction) {
//                System.out.println("going top");
//                try {
//                    Thread.sleep(floorTime);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                currentFloor++;
//                if(currentFloor==10)
//                    direction=false;
//
//            }
            System.out.println("currentFloor : "+currentFloor);
            if(direction){
//                System.out.println("going top");
                try {
                    Thread.sleep(floorTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentFloor++;
                if(currentFloor==11)
                    direction=false;
            }
            if(!direction) {
//                System.out.println("going down");
                try {
                    Thread.sleep(floorTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentFloor--;
                if(currentFloor==1)
                    direction=true;
            }

//            while(!direction) {
//                System.out.println("going down");
//                try {
//                    Thread.sleep(floorTime);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                currentFloor--;
//                if(currentFloor==1)
//                    direction=true;
//            }
        }

    }
}
