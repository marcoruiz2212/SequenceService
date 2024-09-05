package com.appgate.SequenceService.controller;

import com.appgate.SequenceService.model.dto.DistinctSequenceDTO;
import com.appgate.SequenceService.service.ISequenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sequence")
@RequiredArgsConstructor
public class SequenceController {

    private final ISequenceService sequenceService;


    @PostMapping
    public ResponseEntity<Integer> distinctSequence(@Valid @RequestBody final DistinctSequenceDTO sequenceDTO){
        final Integer output = sequenceService.calculateNumDistinct(sequenceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

}
