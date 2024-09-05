package com.appgate.SequenceService.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistinctSequenceDTO {
    @NotBlank(message = "value1 is mandatory")
    private String value1;
    @NotBlank(message = "value2 is mandatory")
    private String value2;

}
