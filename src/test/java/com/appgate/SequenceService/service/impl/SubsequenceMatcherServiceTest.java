package com.appgate.SequenceService.service.impl;


import com.appgate.SequenceService.model.dto.DistinctSubsequenceDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubsequenceMatcherServiceTest {

    private SubsequenceMatcherService sequenceService = new SubsequenceMatcherService();


    @Test
    public void testCalculateSequenceForDifferentWord(){
        DistinctSubsequenceDTO distinctSubsequenceDTO = DistinctSubsequenceDTO.builder().value1("rabbbit").value2("rabbit").build();
        Integer result =  sequenceService.calculateNumDistinct(distinctSubsequenceDTO);
        assertEquals(3, result);

        distinctSubsequenceDTO = DistinctSubsequenceDTO.builder().value1("babgbag").value2("bag").build();
        result =  sequenceService.calculateNumDistinct(distinctSubsequenceDTO);
        assertEquals(5, result);
    }

    @Test
    public void testCalculateSequenceWhenWord2BiggerThatWord1(){
        DistinctSubsequenceDTO distinctSubsequenceDTO = DistinctSubsequenceDTO.builder().value1("rabbbit").value2("rabbitrrrrrasas").build();
        Integer result =  sequenceService.calculateNumDistinct(distinctSubsequenceDTO);
        assertEquals(0, result);
    }


}
