package com.appgate.SequenceService.controller;

import com.appgate.SequenceService.model.dto.DistinctSubsequenceDTO;
import com.appgate.SequenceService.service.ISubsequenceMatcherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sequences")
@RequiredArgsConstructor
public class SubsequenceMatcherController {

    private final ISubsequenceMatcherService subsequenceMatcherService;


    @PostMapping
    public ResponseEntity<Integer> distinctSequence(@Valid @RequestBody final DistinctSubsequenceDTO sequenceDTO){
        final Integer output = subsequenceMatcherService.calculateNumDistinct(sequenceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

}
