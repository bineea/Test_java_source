import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test_map {
    public static void main(String[] main) {
        HashMap<String, String> unsafeMap = new HashMap<>();
        unsafeMap.put("1", "first");
        unsafeMap.put("2", "second");
        System.out.println("~~~" + unsafeMap.get("1"));
        System.out.println(unsafeMap.size());
        unsafeMap.remove("2");
        /*******************************************/
        System.out.println(Integer.bitCount(1));
//        System.out.println(java.security.AccessController.doPrivileged( new sun.security.action.GetPropertyAction(
//                        "jdk.map.althashing.threshold")));
        System.out.println("1 << 16 = "+ (1 << 16));
        int x = 1;
        x <<= 1;
        System.out.println("x <<= 1 = " + x);

        System.out.println(3 / 4);
        /*******************************************/

        //ConcurrentHashMap
        ConcurrentHashMap<String, String> safeMap = new ConcurrentHashMap<>();
        safeMap.put("1", "first");
        safeMap.put("2", "second");
        System.out.println("~~~" + safeMap.get("1"));
        System.out.println(safeMap.size());
        safeMap.remove("1");
        System.out.println("~~~" + safeMap.get("1"));
        System.out.println(safeMap.size());

        //
        System.out.println(2 & 0x7fffffff);
        System.out.println(1 & 0x7fffffff);
        System.out.println(0 & 0x7fffffff);
        System.out.println(-1 & 0x7fffffff);
        //
        System.out.println(-1 & 15);
        System.out.println(16 & 16);

        if(1 == 1) {
            System.out.println("1=1");
        }else if(2==2) {
            System.out.println("2=2");
        }else {
            System.out.println("else");
        }

        for(int i=1; i<10; ++i) {
            System.out.println("i:"+i);
        }

        System.out.println(Integer.numberOfLeadingZeros(16));
        System.out.println( 1 << (16 - 1));
        System.out.println( 1 << 32);
        System.out.println( 1 << 64);
        System.out.println(Integer.numberOfLeadingZeros(16) | ( 1 << (16 - 1)));
        System.out.println((Integer.numberOfLeadingZeros(16) | ( 1 << (16 - 1))) << 16);

    }
}
