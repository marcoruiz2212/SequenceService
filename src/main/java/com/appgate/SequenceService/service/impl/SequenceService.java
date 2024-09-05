package com.appgate.SequenceService.service.impl;

import com.appgate.SequenceService.model.dto.DistinctSequenceDTO;
import com.appgate.SequenceService.service.ISequenceService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SequenceService implements ISequenceService {
    @Override
    public int calculateNumDistinct(DistinctSequenceDTO sequenceDTO) {
        return numDistinct(sequenceDTO.getValue1(),
                sequenceDTO.getValue2());
    }

    private int numDistinct(final String value1,
                            final String value2){

        final int value1Length = value1.length() + 1;
        final int value2Length = value2.length() + 1;

        if(value2Length > value1Length) return 0;

        final int[][] valueSize = new int[value1Length][value2Length];

        for(int i = 0; i< value1Length ; i++){
            valueSize[i][0] = 1;
        }

        for(int i =1; i < value1Length; i++){
            for(int j =1; j< value2Length; j++){
                valueSize[i][j] = valueSize[i-1][j];
                if(value1.charAt(i - 1) == value2.charAt(j -1)){
                    valueSize[i][j] += valueSize[i-1][j-1];
                }
            }
        }
        return valueSize[value1.length()][value2.length()];
    }
}
