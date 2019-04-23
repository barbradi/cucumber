package org.santander.cucumber.demo.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SharedData {

    private String jsonResponse;

}
