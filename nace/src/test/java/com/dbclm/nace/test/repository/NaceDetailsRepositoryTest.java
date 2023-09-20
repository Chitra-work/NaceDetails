package com.dbclm.nace.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dbclm.nace.data.NaceDetailsRepository;
import com.dbclm.nace.data.entity.NaceDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class NaceDetailsRepositoryTest {

    @Autowired
    private NaceDetailsRepository repository;

    @Test
    public void testSaveNaceDetails() {
        NaceDetails naceDetails = new NaceDetails();
        naceDetails.setCode("398481");
        naceDetails.setParent("A");
        naceDetails.setDescription("AGRICULTURE, FORESTRY AND FISHING");

        NaceDetails savedNaceDetails = repository.save(naceDetails);

        assertEquals("398481", savedNaceDetails.getCode());
        assertEquals("A", savedNaceDetails.getParent());
        assertEquals("AGRICULTURE, FORESTRY AND FISHING", savedNaceDetails.getDescription());
    }

    @Test
    public void testFindByCode() {
        NaceDetails naceDetails = new NaceDetails();
        naceDetails.setCode("398481");
        naceDetails.setParent("A");
        naceDetails.setDescription("AGRICULTURE, FORESTRY AND FISHING");

        repository.save(naceDetails);

        Optional<NaceDetails> foundNaceDetails = repository.findByCode("398481");

        assertTrue(foundNaceDetails.isPresent());
        assertEquals("398481", foundNaceDetails.get().getCode());
        assertEquals("A", foundNaceDetails.get().getParent());
        assertEquals("AGRICULTURE, FORESTRY AND FISHING", foundNaceDetails.get().getDescription());
    }

    @Test
    public void testFindByCode_NotFound() {
        Optional<NaceDetails> foundNaceDetails = repository.findByCode("123456");

        assertFalse(foundNaceDetails.isPresent());
    }
}

