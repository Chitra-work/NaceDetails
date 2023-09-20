package com.dbclm.nace.test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dbclm.nace.data.NaceDetailsRepository;
import com.dbclm.nace.data.entity.NaceDetails;
import com.dbclm.nace.service.NaceDetailsService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class NaceDetailsServiceTest {

    @Mock
    private NaceDetailsRepository repository;

    @InjectMocks
    private NaceDetailsService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveNaceDetails() {
        NaceDetails naceDetails = new NaceDetails();
        when(repository.save(any(NaceDetails.class))).thenReturn(naceDetails);

        NaceDetails savedDetails = service.saveNaceDetails(naceDetails);

        verify(repository, times(1)).save(naceDetails);
        assertNotNull(savedDetails);
    }

    @Test
    public void testGetNaceDetails() {
        String code = "398481";
        NaceDetails naceDetails = new NaceDetails();
        when(repository.findByCode(code)).thenReturn(Optional.of(naceDetails));

        Optional<NaceDetails> result = service.getNaceDetails(code);

        verify(repository, times(1)).findByCode(code);
        assertTrue(result.isPresent());
        assertEquals(naceDetails, result.get());
    }
}
