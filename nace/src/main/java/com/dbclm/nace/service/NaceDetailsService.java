package com.dbclm.nace.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbclm.nace.data.NaceDetailsRepository;
import com.dbclm.nace.data.entity.NaceDetails;

@Service
public class NaceDetailsService {
    @Autowired
    private NaceDetailsRepository repository;

    public NaceDetails saveNaceDetails(NaceDetails naceDetails) {
        return repository.save(naceDetails);
    }

    public Optional<NaceDetails> getNaceDetails(String code) {
        return repository.findByCode(code);
    }
}