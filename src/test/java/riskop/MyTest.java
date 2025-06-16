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
    void TestNPE() {
        java.lang.NullPointerException npe = new java.lang.NullPointerException();
        try {
            toFromJson.toFromJson(npe);
        }
        catch (java.lang.NullPointerException npe2) {
            // okay, expected
            Assertions.assertEquals(npe.getMessage(), npe2.getMessage());
        }
        catch (Throwable t) {
            throw new RuntimeException();
        }
    }

    @Test
    void TestMyNPE() {
        NullPointerException npe = new NullPointerException();
        try {
            toFromJson.toFromJson(npe);
        }
        catch (NullPointerException npe2) {
            // okay, expected
            Assertions.assertEquals(npe.getMessage(), npe2.getMessage());
        }
        catch (Throwable t) {
            throw new RuntimeException();
        }
    }

}

