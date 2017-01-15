import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Created by James Pickles on 15/01/2017.
 */
public class CreateObj {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cls = null;
        ArrayList<String> conArgs = new ArrayList<>();
        String str = "1";
        System.out.println("Please enter class: ");

        try {
            cls = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (!str.equals("0")) {
                System.out.println("Please enter constructor args (0 when finished): ");
                str = br.readLine();
                if(!str.equals("0")) {
                    conArgs.add(str);
                }
            }

        } catch (IOException | NullPointerException e)  {
            e.printStackTrace();
        }
        System.out.println("conargs size: " + conArgs.size());
        try {
            Class reflectClass = Class.forName(cls);
            Constructor[] constructors = reflectClass.getConstructors();
            Constructor constructor = null;
            for(Constructor c : constructors) {
                System.out.println(c.getTypeParameters().length);
                if (c.getTypeParameters().length == conArgs.size()) {
                    constructor = c;
                    break;
                }
            }
            System.out.println(constructor.toString());
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

    } // End of main
}
