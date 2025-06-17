package riskop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyTest {

    @Autowired
    ToFromJson toFromJson;

    @Test
    void TestIAE() {
        IllegalArgumentException e1 = new IllegalArgumentException();
        try {
            toFromJson.toFromJson(e1);
        }
        catch (IllegalArgumentException e2) {
            // okay, expected
            Assertions.assertEquals(e1.getMessage(), e2.getMessage());
        }
        catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @Test
    void TestMyIAE() {
        MyIllegalArgumentException e1 = new MyIllegalArgumentException();
        try {
            toFromJson.toFromJson(e1);
        }
        catch (MyIllegalArgumentException e2) {
            // okay, expected
            Assertions.assertEquals(e1.getMessage(), e2.getMessage());
        }
        catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

}

