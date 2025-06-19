package riskop;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Config {

    //
    // https://github.com/FasterXML/jackson-databind/issues/1986
    //
    //@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    //public abstract class ThrowablelMixin {}
    //public abstract class StackTraceElementMixin { // With this property name and getter name will be the same.
    //    @JsonProperty("className") private String declaringClass;
    //}

    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        PolymorphicTypeValidator ptv =
                BasicPolymorphicTypeValidator.builder()
                        .allowIfSubType(Object.class)
                        .build();
        //objectMapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.EVERYTHING, JsonTypeInfo.As.WRAPPER_ARRAY);
        objectMapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

        // Configure deserialization features
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //objectMapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);

        // Register mixins
        //objectMapper.addMixIn(Throwable.class, ThrowablelMixin.class);
        //objectMapper.addMixIn(StackTraceElement.class, StackTraceElementMixin.class);
        return objectMapper;
    }
}
