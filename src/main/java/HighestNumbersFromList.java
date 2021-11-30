import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighestNumbersFromList {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList();
        list.add(50);
        list.add(30);
        list.add(55);
        list.add(35);
        list.add(45);
        list.add(40);
        System.out.println("Elements in the list are "+list);
        Collections.sort(list);
        System.out.println("Highest is "+list.get(list.size()-1));
        System.out.println("SecondHighest is "+list.get(list.size()-2));
    }
}
