package hieu.accountservice.model;

import lombok.*;

import java.time.LocalDate;

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
