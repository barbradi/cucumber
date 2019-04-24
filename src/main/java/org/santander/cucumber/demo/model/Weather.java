package org.santander.cucumber.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.santander.cucumber.demo.model.County;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    private LocalDateTime date;
    private List<County> counties;
}
