package com.podzirei.update_dates.service;

import com.podzirei.update_dates.dto.DataDto;
import com.podzirei.update_dates.entity.Data;
import com.podzirei.update_dates.mapper.DataMapper;
import com.podzirei.update_dates.repository.JpaDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DefaultDataService implements DataService {

    private static final int BATCH_SIZE = 50;
    private final JpaDataRepository jpaDataRepository;
    private final DataMapper dataMapper;

    @Override
    @Transactional
    public void updateDates() {
        Pageable paging = PageRequest.of(0, BATCH_SIZE, Sort.by(Sort.Direction.ASC, "id"));
        Page<Data> page = jpaDataRepository.findAll(paging);

        List<DataDto> dataDtoList = dataMapper.toDataDtos(page.getContent());
        changeDateAndSave(dataDtoList);

        while (page.hasNext()) {
            page = jpaDataRepository.findAll(page.nextPageable());
            dataDtoList.addAll(dataMapper.toDataDtos(page.getContent()));
            changeDateAndSave(dataDtoList);
        }
    }

    private void changeDateAndSave(List<DataDto> dataDtoList) {
        dataDtoList.forEach(dataDto -> dataDto.setUpdatedTime(LocalDateTime.now()));
        jpaDataRepository.saveAll(dataMapper.toDatas(dataDtoList));
    }
}
