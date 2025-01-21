import java.util.*;
public class Tempreaturenew {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many days' tempreature ?");
        int numofdays = sc.nextInt();
        int sum = 0;
        for(int i = 0; i<numofdays; i++) {
            System.out.println("Day " + i + "\'s high temp is : ");
            int next = sc.nextInt();
            sum += next;
        }

        double avgtemp = sum/numofdays;
        System.out.println();
        System.out.println("Average tempereature is : " + avgtemp);
        sc.close();
    }
}