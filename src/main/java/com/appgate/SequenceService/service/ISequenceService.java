package com.appgate.SequenceService.service;

import com.appgate.SequenceService.model.dto.DistinctSequenceDTO;

public interface ISequenceService {

    int calculateNumDistinct(DistinctSequenceDTO sequenceDTO);
}
