import java.util.*;
class TempbyArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many days' temperature ?");
        int numofdays = sc.nextInt();
        int[] temps = new int[numofdays];
        // Recording tempreatures and finding average
        int sum=0;
        for (int i=0; i<numofdays; i++) {
            System.out.println("Days " + (i+1) + "\'s high temperature : ");
            temps[i] = sc.nextInt();
            sum += temps[i];
        }
        double avgtemp = sum / numofdays;
        System.out.println();
        // Counting days above average
        int above = 0;
        for(int i=0; i<temps.length; i++) {
            if(temps[i] > avgtemp) {
                above++;
            }
        }
        System.out.println("Average temperature is : " + avgtemp);
        System.out.println("There are " + above + " days above average temperature.");
        sc.close();
    }
}