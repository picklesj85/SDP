import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by James Pickles on 18/01/2017.
 */
class ClassTest {

    //change string depending on which class you want to test
    private String classToTest = "PassClass";
    private Class reflectClass = null;

    @BeforeEach
    void setUp() {
        try {
            reflectClass = Class.forName(classToTest);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testsNoMoreThanFourFields() {
        int fields = reflectClass.getDeclaredFields().length;
        assertTrue(fields <= 4);
    }

    @Test
    public void testsNoNonPrivateFields() {
        Field[] fields = reflectClass.getDeclaredFields();
        for (Field f : fields) {
            int mod = f.getModifiers();
            assertTrue(Modifier.isPrivate(mod));
        }
    }

    @Test
    public void testsNoFieldsOfTypeArrayList() {
        Field[] fields = reflectClass.getDeclaredFields();
        for (Field f : fields) {
            assertNotEquals("java.util.ArrayList", f.getType().getName());
        }
    }

    @Test
    public void testsNoLessThanTwoPrivateHelperMethods() {
        Method[] methods = reflectClass.getDeclaredMethods();
        int count = 0;
        for(Method m : methods) {
            int mod = m.getModifiers();
            if (Modifier.isPrivate(mod)) {
                count++;
            }
        }
        assertTrue(count >= 2);
    }

    @Test
    public void testsHasNoThrowsClause() {
        Method[] methods = reflectClass.getDeclaredMethods();
        for (Method m : methods) {
            Class [] ex = m.getExceptionTypes();
            assertTrue(ex.length == 0);
        }
    }

    @Test
    public void testsNoMethodReturnsAnInt() {
        Method[] methods = reflectClass.getDeclaredMethods();
        for (Method m : methods) {
           assertNotEquals("int", m.getReturnType().getName());
        }
    }

    @Test
    public void testsItHasZeroArgCons() {
        Constructor[] constructors = reflectClass.getConstructors();
        Optional result = Arrays.stream(constructors).filter(c -> c.getParameterCount() == 0).findAny();
        assertTrue(result.isPresent());
    }

}