package org.santander.cucumber.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class County {

    private String name;
    private int temperature;
    private boolean isRaining;
}
