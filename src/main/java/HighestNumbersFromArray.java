import java.util.Arrays;
public class HighestNumbersFromArray {
    public static void main(String[] args) {
        int[] list = {50, 101, 20, 90, 80, 3, 45};
        Arrays.sort(list);
        System.out.println("highest is "+list[list.length-1]);
        System.out.println("secondHighest "+list[list.length-2]);
    }
}
