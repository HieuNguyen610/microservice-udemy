package hieu.statisticservice.service;

import hieu.statisticservice.dto.StatisticDto;

import java.util.List;

public interface StatisticService {

    void add(StatisticDto statisticDto);
    List<StatisticDto> getAll();
    StatisticDto getById(Long id);
    void update(StatisticDto statisticDto);
    void delete(Long id);
}
