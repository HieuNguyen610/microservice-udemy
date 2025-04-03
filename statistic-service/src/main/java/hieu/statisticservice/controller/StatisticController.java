package hieu.statisticservice.controller;

import hieu.statisticservice.dto.StatisticDto;
import hieu.statisticservice.repository.StatisticRepository;
import hieu.statisticservice.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/statistics")
    public List<StatisticDto> getStatistics() {
        return statisticService.getAll();
    }

    @GetMapping("/statistics/{id}")
    public StatisticDto getStatisticById(@PathVariable Long id) {
        return statisticService.getById(id);
    }

    @PostMapping("/statistic")
    public StatisticDto add(StatisticDto statisticDto) {
        statisticService.add(statisticDto);
        return statisticDto;
    }

    @PutMapping("/statistic")
    public StatisticDto update(@RequestBody StatisticDto statisticDto) {
        statisticService.update(statisticDto);
        return statisticDto;
    }

    @DeleteMapping("/statistics/{id}")
    public void delete(@PathVariable Long id) {
        statisticService.delete(id);
    }
}
