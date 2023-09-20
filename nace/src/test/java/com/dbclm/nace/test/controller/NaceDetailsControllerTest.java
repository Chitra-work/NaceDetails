package com.dbclm.nace.test.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dbclm.nace.controller.NaceDetailsController;
import com.dbclm.nace.data.entity.NaceDetails;
import com.dbclm.nace.service.NaceDetailsService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NaceDetailsControllerTest {

    @Mock
    private NaceDetailsService service;

    private NaceDetailsController controller;

    @Test
    public void testSaveNaceDetails() {
        NaceDetails naceDetails = new NaceDetails();
        when(service.saveNaceDetails(any(NaceDetails.class))).thenReturn(naceDetails);

        controller = new NaceDetailsController();
        ResponseEntity<String> response = controller.saveNaceDetails(naceDetails);

        verify(service, times(1)).saveNaceDetails(naceDetails);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(naceDetails, response.getBody());
    }

    @Test
    public void testGetNaceDetails() {
        String code = "398481";
        NaceDetails naceDetails = new NaceDetails();
        when(service.getNaceDetails(code)).thenReturn(Optional.of(naceDetails));

        controller = new NaceDetailsController();
        ResponseEntity<?> response = controller.getNaceDetails(code);

        verify(service, times(1)).getNaceDetails(code);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(naceDetails, response.getBody());
    }

    @Test
    public void testGetNaceDetailsNotFound() {
        String code = "123456";
        when(service.getNaceDetails(code)).thenReturn(Optional.empty());

        controller = new NaceDetailsController();
        ResponseEntity<?> response = controller.getNaceDetails(code);

        verify(service, times(1)).getNaceDetails(code);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}

