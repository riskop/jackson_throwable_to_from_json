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
    }
}
