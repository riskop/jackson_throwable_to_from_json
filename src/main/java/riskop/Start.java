package riskop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(Start.class);

    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {

        ErrorCodeWithMessage errorCodeWithMessage = new ErrorCodeWithMessage(42, "Everything and nothing else");
        Exception myException = new Exception();
        String json1 = objectMapper.writeValueAsString(myException);
        logger.info("", myException);
        //logger.info("json1: " + json1);
        Throwable t = objectMapper.readValue(json1, Throwable.class);
        logger.info("t: " + t);
        logger.info("-----------------------------------------------");
        logger.info("", t);
        String json2 = objectMapper.writeValueAsString(t);
        //logger.info("json2: " + json2);
    }
}
