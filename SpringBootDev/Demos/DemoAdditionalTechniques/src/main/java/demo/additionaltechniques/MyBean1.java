package demo.additionaltechniques;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean1 {

    @Value("${name}")
    private String name;   

    @Override
    public String toString() {
        return String.format("Hello from MyBean1, name %s", name);
    }
}
