package riskop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToFromJson {

    Logger logger = LoggerFactory.getLogger(ToFromJson.class);

    @Autowired
    private ObjectMapper objectMapper;

    public void toFromJson(Throwable in) throws Throwable {
        String json1 = objectMapper.writeValueAsString(in);
        //logger.info("in: ", in);
        //logger.info("json1: " + json1);
        Throwable out = objectMapper.readValue(json1, Throwable.class);
        //logger.info("out: " + out);
        //String json2 = objectMapper.writeValueAsString(out);
        //logger.info("json2: " + json2);
        throw out;
    }

}
