import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test_map {
    public static void main(String[] main) {
        HashMap<String, String> unsafeMap = new HashMap<>();
        unsafeMap.put("1", "first");
        unsafeMap.put("2", "second");
        System.out.println("~~~" + unsafeMap.get("1"));

        unsafeMap.remove("2");
        /*******************************************/
        System.out.println(Integer.bitCount(1));
        System.out.println(java.security.AccessController.doPrivileged( new sun.security.action.GetPropertyAction(
                        "jdk.map.althashing.threshold")));
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

    }
}
