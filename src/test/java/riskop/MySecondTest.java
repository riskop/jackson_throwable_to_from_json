package riskop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@Disabled
@SpringBootTest
public class MySecondTest {

    @Autowired
    ToFromJson toFromJson;

    @Test
    void TestSimpleThrowable() {
        Throwable throwable = new Throwable();
        try {
            toFromJson.toFromJson(throwable);
        }
        catch (Throwable throwable2) {
            // ok expected
            Assertions.assertEquals(throwable.getStackTrace().length, throwable2.getStackTrace().length);
        }
    }

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

    @Test
    void TestMyException() {
        MyException me = new MyException(new ErrorCodeWithMessage(42, "the answer"), "messaggeee", new IllegalStateException("III"));
        try {
            toFromJson.toFromJson(me);
        }
        catch (MyException me2) {
            // okay, expected
            Assertions.assertEquals(me.getCause().getMessage(), me2.getCause().getMessage());
            Assertions.assertEquals(me.getErrorCodeWithMessage().getErrorCode(), me2.getErrorCodeWithMessage().getErrorCode());
            Assertions.assertEquals(me.getErrorCodeWithMessage().getMessage(), me2.getErrorCodeWithMessage().getMessage());
            Assertions.assertEquals(me.getMessage(), me2.getMessage());
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void TestMyExceptionNaked() {
        MyException me = new MyException();
        try {
            toFromJson.toFromJson(me);
        }
        catch (MyException me2) {
            // okay, expected
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void TestMyRuntimeException() {
        MyRuntimeException mre = new MyRuntimeException();
        try {
            toFromJson.toFromJson(mre);
        }
        catch (MyRuntimeException mre2) {
            // okay, expected
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}

