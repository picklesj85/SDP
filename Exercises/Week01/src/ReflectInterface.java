import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;

/**
 * Created by James Pickles on 15/01/2017.
 */
public class ReflectInterface {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the class name: ");
        String clName = null;
        try {
            clName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Class reflectClass = null;
        try {

            reflectClass = Class.forName(clName);
            System.out.printf("%s interface %s {\n\n", Modifier.toString(reflectClass.getModifiers()), reflectClass.getName());

            Field[] fields = reflectClass.getFields();
            Method[] methods = reflectClass.getDeclaredMethods();
            Constructor[] constructors = reflectClass.getConstructors();
            int modifiers = reflectClass.getModifiers();

            for (Field f : fields) {
                System.out.printf("    %s %s %s;\n\n", Modifier.toString(f.getModifiers()), f.getType(), f.getName());
            }

            for (Method m : methods) {
                System.out.printf("    %s %s(); \n", m.getReturnType(), m.getName());
            }


            System.out.println("\n}");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    } //End of Main


}
