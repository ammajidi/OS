import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Process> readFile(String file) throws FileNotFoundException {
        Process process;
        ArrayList<Process> processes = new ArrayList<Process>();
        FileInputStream fileInputStream=new FileInputStream(file);
        Scanner input = new Scanner(fileInputStream);
        String line;
        Scanner info;
        int id, arrivalTime,bursTime;

        while(input.hasNext()){
            line = input.nextLine();
            info = new Scanner(line);
            id = Integer.parseInt(info.next()); //PID
            arrivalTime = Integer.parseInt(info.next()); //Arrival Time
            bursTime = Integer.parseInt(info.next()); //CPU Burst

            process = new Process(id, arrivalTime, bursTime); //create new Process object
            processes.add(process); //add process to array

        }
        return processes;
    }
    public static void draw(ArrayList<Process> processes){
        String result="";
        System.out.print("| PID | Arrival | Burst |\n"+"-------------------------\n");
        for (Process p:processes){
        System.out.println("|  "+p.getID()+"  |    "+p.getArrivalTime()+"    |   "+p.getBurstTime()+"   |");
        }
        System.out.println("-------------------------");
    }
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList processes=Main.readFile("proc.txt");
        draw(processes);
        FCFS.run(processes);
        SJF.run(processes);
    }
}
