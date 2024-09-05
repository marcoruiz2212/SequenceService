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

        final int sizeValue1 = value1.length() + 1;
        final int sizeValue2 = value2.length() + 1;

        if(sizeValue2 > sizeValue1) return 0;

        final int[][] valueSize = new int[sizeValue1][sizeValue2];
        for(int i = 0; i< sizeValue1 ; i++){
            valueSize[i][0] = 1;
        }

        for(int i =1; i < sizeValue1; i++){
            for(int j =1; j< sizeValue2; ++j){
                valueSize[i][j] = valueSize[i-1][j];
                if(value1.charAt(i - 1) == value2.charAt(j -1)){
                    valueSize[i][j] += valueSize[i-1][j-1];
                }

            }
        }
        return valueSize[value1.length()][value2.length()];
    }
}
