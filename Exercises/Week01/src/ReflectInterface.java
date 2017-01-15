import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        System.out.printf("You entered: %s", clName);

    } //End of Main


}
