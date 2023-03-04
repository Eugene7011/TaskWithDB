package com.podzirei.update_dates.mapper;

import com.podzirei.update_dates.dto.DataDto;
import com.podzirei.update_dates.entity.Data;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataMapper {

    DataDto toDataDto(Data data);

    Data toData(DataDto dataDto);

    List<DataDto> toDataDtos(List<Data> datas);

    List<Data> toDatas(List<DataDto> dataDtos);

}
