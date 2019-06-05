public class Passenger extends Thread{
    int id;
    int currentLevel;
    boolean io;//true=in Elevator false=out Ele...
    Elevator elevator;
    public Passenger(int id, int currentLevel,Elevator elevator) {

        this.id=id;
        this.currentLevel=currentLevel;
        this.io=true;
        this.elevator=elevator;
        // TODO Auto-generated constructor stub
    }

    public void run() {
        while (true) {
            System.out.println("passenger : "+this.id+" is calling from floor = " +this.currentLevel );

//			call for elevator
            try {
                elevator.floors[currentLevel].acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("passenger : "+this.id+" is getting in" );
            int requested =randomFloor(this.currentLevel);
            System.out.println("passenger : "+this.id+" is pushing floor = "+requested );
            try {
                elevator.floors[requested].acquire();
                sleep(calcTime(currentLevel,requested));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//			wait calculates from passage length

            System.out.println("passenger : "+this.id+" is getting out" );
            this.elevator.floors[currentLevel].release();

//            Controller.elevator.release();
            this.currentLevel=requested;

            try {
                sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.currentLevel=requested;
//			busy wait
        }
    }
    private int calcTime(int currentLevel,int requested){
        int  floorTime=this.elevator.floorTime;
        if (this.elevator.direction){//going top
            if (currentLevel<requested)
                return (requested-currentLevel)*floorTime;
            else
                return (10-currentLevel)*floorTime+(10-requested)*floorTime;
        }
        else //going down
        {
            if (currentLevel>requested)
                return (currentLevel-requested)*floorTime;
            else
                return (currentLevel)*floorTime + (requested)*floorTime;
        }
    }
    private int randomFloor(int currenLlevel) {
        // TODO Auto-generated method stub
        int floor = (int)(Math.random()*10);
        if(floor==0)
            floor++;
        return floor;
    }


}


