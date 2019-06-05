import java.util.ArrayList;

public class SJF {
    public static void run(ArrayList<Process> rawOrder){
        if(rawOrder==null || rawOrder.size()==0)
            return;
//        System.out.println("Original Array: " + rawOrder.toString());
        int size = rawOrder.size();
        for (int i = 0; i <size-1 ; i++) {
            for (int j = 0; j <size-i-1 ; j++) {
                //check the adjacent elements
                if(rawOrder.get(j).getBurstTime()>rawOrder.get(j+1).getBurstTime()){
                    //swap the elements
                    Process temp = rawOrder.get(j);
                    rawOrder.set(j,rawOrder.get(j+1));
                    rawOrder.set(j+1,temp);
                }
            }
        }
        System.out.println("SJF order: " +  rawOrder.toString());
    }

}
