package com.example.hms.dto;

import com.example.hms.entity.type.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BloodGroupCountResponseEntity {

    private BloodGroup bloodGroup;
    private Long count;

}
