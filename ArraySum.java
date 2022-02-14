import java.util.*;

public class ArraySum{
    public static void createArray(int[] nums, Scanner scan){
        for(int i = 0; i < nums.length; i++){
            System.out.print("Enter a number for index " + i + ": ");
            String s = scan.nextLine();
            int num;
            try {
                num = Integer.parseInt(s);    
                nums[i] = num;
            } catch (NumberFormatException e) {
                System.out.println("Please try again with an integer");
                return;
            }
        }
    }

    public static int sumArray(int[] nums){
        System.out.print("Summing array [");
        int big = Integer.MAX_VALUE;
        int small = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
            if(i < nums.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && big - nums[i] <= sum){//adding next int would overflow
                System.out.println("Overflow, returning");
                return 0;
            }
            else if(nums[i] < 0 && small - nums[i] >= sum){//^
                System.out.println("Underflow, returning");
                return 0;
            }
            sum += nums[i];
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("This program prompts the user for a number,"
        +" which will be the length of the array of ints to sum.\n"
        +"Then prompts the user for the numbers to sum.\n");
        System.out.print("How many ints do you want: ");
        String s = scan.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(s);    
        } catch (NumberFormatException e) {
            System.out.println("Please try again with an integer");
            scan.close();
            return;
        }
        
        int[] nums;
        if(num <= 0){
            System.out.println("Cannot operate on array of negative or zero length!");
            scan.close();
            return;
        }
        nums = new int[num]; 
        createArray(nums, scan);
        int res = sumArray(nums);
        System.out.println("Result is: " + res);
        scan.close();
    }
}