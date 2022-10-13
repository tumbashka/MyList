import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Integer[] arrInt = new Integer[]{1, 5, 9, 3, 4, 8, 4};
        Object[] arrObj = new Object[]{"string", 5, 1.2, 'c'};

        MyList<Object> list1 = new MyList<>(arrInt);
        System.out.println(list1.getAuthor() + " " + list1.contains('c'));

        Object[] arrTest = list1.toArray();
        for (int i = 0; i < arrTest.length; i++) {
            System.out.print(arrTest[i] + " ");
        }
        System.out.println();



        Integer[] arr = new Integer[]{4,3,1};
        list1.retainAll(List.of(arr));


        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.toArray()[i] + " ");
        }
        System.out.println();


    }
}