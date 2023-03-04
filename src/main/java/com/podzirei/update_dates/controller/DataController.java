package com.podzirei.update_dates.controller;

import com.podzirei.update_dates.service.DataService;
import com.podzirei.update_dates.service.MockServiceData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {

    private final MockServiceData mockServiceData;
    private final DataService dataService;

    @GetMapping("/mock")
    public void fillMockData() {
        mockServiceData.saveMockData();
    }

    @GetMapping()
    public void updateDates() {
        dataService.updateDates();
    }

}
