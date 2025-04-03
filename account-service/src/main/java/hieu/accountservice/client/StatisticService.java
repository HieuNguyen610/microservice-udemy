package hieu.accountservice.client;

import hieu.accountservice.model.StatisticDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="statistic-service", url="http://localhost:9082")
public interface StatisticService {

    @PutMapping("/statistic")
    StatisticDto update(@RequestBody StatisticDto statisticDto);

    @GetMapping("/statistics")
    List<StatisticDto> getStatistics();

    @GetMapping("/statistics/{id}")
    StatisticDto getStatisticById(@PathVariable Long id);

    @PostMapping("/statistic")
    StatisticDto add(StatisticDto statisticDto);

}
