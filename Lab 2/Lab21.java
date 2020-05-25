import java.util.*; 
  
public class Lab21 { 
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(12);
        list.add(35);
        list.add(52);
        list.add(74);

        System.out.println("LinkedList: " + list);

        Object[] array = list.toArray();
        System.out.println("Array: " + Arrays.toString(array)); 
    } 
} 