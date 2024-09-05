package com.appgate.SequenceService.service;

import com.appgate.SequenceService.model.dto.DistinctSubsequenceDTO;

public interface ISubsequenceMatcherService {

    int calculateNumDistinct(DistinctSubsequenceDTO sequenceDTO);
}
