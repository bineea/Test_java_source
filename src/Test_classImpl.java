import java.lang.reflect.Type;
import java.util.Arrays;

public class Test_classImpl implements Test_classIf<Test_class>{

    public static void main(String[] args) {
        Test_classImpl test = new Test_classImpl();
        Type[] genericInterfaces = test.getClass().getGenericInterfaces();
        Arrays.asList(genericInterfaces).stream().forEach(System.out::println);
        Class<?>[] interfaces = test.getClass().getInterfaces();
        Arrays.asList(interfaces).stream().forEach(System.out::println);
    }
}
