package com.podzirei.update_dates.service;

import com.podzirei.update_dates.entity.Data;
import com.podzirei.update_dates.repository.JpaDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class MockServiceData {

    private final JpaDataRepository jpaDataRepository;

    public void saveMockData() {
        char[] mockData = new char[1000 * 1000];

        for (int i = 0; i < 1_000_000; i++) {
            mockData[i] = 'A';
        }
        String string = new String(mockData);
        Data data = Data.builder()
                .data(string)
                .updatedTime(LocalDateTime.now())
                .build();

        for (int i = 0; i < 500; i++) {
            data.setId(i + 1);
            jpaDataRepository.save(data);
        }
    }

}
