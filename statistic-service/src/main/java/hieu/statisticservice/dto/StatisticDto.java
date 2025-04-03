package hieu.statisticservice.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StatisticDto {

    private Long id;
    private String message;
    private LocalDate createdDate;
}
