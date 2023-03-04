package com.podzirei.update_dates.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_id")
    @SequenceGenerator(name = "data_id", sequenceName = "data_id", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "data", nullable = false)
    private String data;

    @Column(name = "updated_time", nullable = false)
    private LocalDateTime updatedTime;
}
