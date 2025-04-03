package hieu.statisticservice.service.impl;

import hieu.statisticservice.dto.StatisticDto;
import hieu.statisticservice.entity.Statistic;
import hieu.statisticservice.repository.StatisticRepository;
import hieu.statisticservice.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;
    private final ModelMapper modelMapper;

    @Override
    public void add(StatisticDto statisticDto) {
        statisticRepository.save(convertDtoToEntity(statisticDto));
    }

    @Override
    public List<StatisticDto> getAll() {
        return convertEntitiesToDtos(statisticRepository.findAll());
    }

    @Override
    public StatisticDto getById(Long id) {
        return convertEntityToDto(findStatisticById(id));
    }

    @Override
    public void update(StatisticDto statisticDto) {
        Statistic statistic = findStatisticById(statisticDto.getId());
        statistic.setMessage(statisticDto.getMessage());
        statisticRepository.save(statistic);
    }

    @Override
    public void delete(Long id) {
        Statistic statistic = findStatisticById(id);
        statisticRepository.delete(statistic);
    }

    private Statistic findStatisticById(Long id) {
        return statisticRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Statistic not found"));
    }

    private StatisticDto convertEntityToDto(Statistic entity) {
        return modelMapper.map(entity, StatisticDto.class);
    }

    private Statistic convertDtoToEntity(StatisticDto dto) {
        return modelMapper.map(dto, Statistic.class);
    }

    private List<StatisticDto> convertEntitiesToDtos(List<Statistic> entities) {
        return entities.stream().map(this::convertEntityToDto).collect(toList());
    }
}
