import sun.awt.geom.AreaOp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test_list {

    public static void main(String[] args) {
        ArrayList<String> testArray = new ArrayList<>();
        testArray.add(0, "test_0");
        testArray.add(1, "test_1");
        testArray.add(2, "test_2");
        testArray.add(3, "test_3");
        System.out.println("testArray——size:"+testArray.size());
        System.out.println("testArray——1:"+testArray.get(1));

        testArray.remove(2);
        System.out.println("testArray——size:"+testArray.size());
        System.out.println("testArray——2:"+testArray.get(2));

        testArray.add(2, "test_2");
        System.out.println("testArray——size:"+testArray.size());
        System.out.println("testArray——2:"+testArray.get(2));

        LinkedList<String> testLink = new LinkedList<>();
        testLink.add(0, "test_0");
        testLink.add(1, "test_1");
        testLink.add(2, "test_2");
        testLink.add(3, "test_3");
        System.out.println("testLink——size:"+testLink.size());
    }
}
