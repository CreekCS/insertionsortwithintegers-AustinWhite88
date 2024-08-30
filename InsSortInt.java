//import the necessary libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InsSortInt
{

   // Reads the numbers from randints.txt file and puts them in the arraylist list.
   public static ArrayList<Integer> input(File file) throws FileNotFoundException {
       ArrayList<Integer> list = new ArrayList<>();
       Scanner scanner = new Scanner(file);

       while (scanner.hasNextInt()) {
           list.add(scanner.nextInt());
       }

       scanner.close();
       return list;
   }

   //Converts the array list into an array
   public static int[] convert(ArrayList<Integer> list) {
       int[] array = new int[list.size()];
       for (int i = 0; i < list.size(); i++) {
           array[i] = list.get(i);
       }
       return array;
   }

   // Sorts the array from integers ordering from greatest to smallest using insertion sort
   public static void sort(int[] array) {
       for (int i = 1; i < array.length; i++) {
           int temp = array[i];
           int j = i - 1;

           // Moves elements in the array one position ahead that are smaller than temp
           while (j >= 0 && array[j] < temp) {
               array[j + 1] = array[j];
               j--;
           }
           array[j + 1] = temp;
       }
   }

   public static void main(String[] args) {
       try {
           //Randints.txt file (containing integers)
           File file = new File("randInts.txt");

           // Reads the file and puts the ints into the arraylist list
           ArrayList<Integer> list = input(file);

           //Converts the arraylist into an array
           int[] array = convert(list);

           //Sorts the array from greatest to smallest
           sort(array);

           //Prints the smallest and largest values in the array
           System.out.println("the smallest value in the array is: " +array[0]);
           System.out.println("the largest value in the array is: " +array[array.length-1]);

       } catch (FileNotFoundException e) {
           //Makes it to where the code can run if there was no file found
           System.err.println("File not found: " + e.getMessage());
       }
   }
}