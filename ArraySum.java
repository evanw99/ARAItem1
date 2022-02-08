import java.util.*;

public class ArraySum{
    public int sumArray(int size){
        Random rand = new Random();
        int[] numbers = new int[num];
        for(int i = 0; i < size; i++){
            numbers[i] = rand.nextInt();
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("This program prompts the user for a number,"
        +" which will be the length of the array of ints to sum.\n");
        System.out.println("How many ints do you want: ");
        String s = scan.nextLine();
        try {
            int num = Integer.parseInt(s);    
        } catch (NumberFormatException e) {
            //TODO: handle exception
            System.out.println("Please try again with an integer");
            scan.close();
        }
        
        if(num <= 0){
            System.out.println("Cannot operate on array of negative or zero length!");
        }
        else{
            int res = sumArray(num);
            System.out.println("Result is: " + res);
        }
        //System.out.println("Here's what you input: " + s);
        scan.close();
    }
}