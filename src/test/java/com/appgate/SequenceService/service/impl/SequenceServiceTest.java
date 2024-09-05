package com.appgate.SequenceService.service.impl;


import com.appgate.SequenceService.model.dto.DistinctSequenceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequenceServiceTest {

    private SequenceService sequenceService = new SequenceService();


    @Test
    public void testCalculateSequenceForDifferentWord(){
        DistinctSequenceDTO distinctSequenceDTO = DistinctSequenceDTO.builder().value1("rabbbit").value2("rabbit").build();
        Integer result =  sequenceService.calculateNumDistinct(distinctSequenceDTO);
        assertEquals(3, result);

        distinctSequenceDTO = DistinctSequenceDTO.builder().value1("babgbag").value2("bag").build();
        result =  sequenceService.calculateNumDistinct(distinctSequenceDTO);
        assertEquals(5, result);
    }

    @Test
    public void testCalculateSequenceWhenWord2BiggerThatWord1(){
        DistinctSequenceDTO distinctSequenceDTO = DistinctSequenceDTO.builder().value1("rabbbit").value2("rabbitrrrrrasas").build();
        Integer result =  sequenceService.calculateNumDistinct(distinctSequenceDTO);
        assertEquals(0, result);
    }


}
