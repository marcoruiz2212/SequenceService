package com.appgate.SequenceService.controller;

import com.appgate.SequenceService.model.dto.DistinctSequenceDTO;
import com.appgate.SequenceService.service.ISequenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SequenceController.class)
public class SequenceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ISequenceService sequenceService;

    @Test
    public void testDistinctSequenceSuccessfulValidation() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final DistinctSequenceDTO distinctSequenceDTO = DistinctSequenceDTO.builder().value1("val1").value2("val2").build();

        Mockito.when(sequenceService.calculateNumDistinct(any())).thenReturn(5);

        final MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.
                post("/sequence")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(distinctSequenceDTO))
                .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("5", response.getContentAsString());
    }

    @Test
    public void testDistinctSequenceBadRequest() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final DistinctSequenceDTO distinctSequenceDTO = DistinctSequenceDTO.builder().value1("val1").build();

         mockMvc.perform(MockMvcRequestBuilders.
                        post("/sequence")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(distinctSequenceDTO))
                        .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn().getResponse();

    }
}
