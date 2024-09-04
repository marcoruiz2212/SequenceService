package com.appgate.SequenceService.controller;

import com.appgate.SequenceService.model.dto.DistinctSequenceDTO;
import com.appgate.SequenceService.service.ISequenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sequence")
@RequiredArgsConstructor
public class SequenceController {

    private final ISequenceService sequenceService;


    @PostMapping
    public ResponseEntity<String> distinctSequence(@RequestBody final DistinctSequenceDTO sequenceDTO){
        final String output = sequenceService.calculateNumDistinct(sequenceDTO.getValue1(), sequenceDTO.getValue2());
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

}
