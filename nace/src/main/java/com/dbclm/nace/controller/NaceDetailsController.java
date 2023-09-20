package com.dbclm.nace.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbclm.nace.data.entity.NaceDetails;
import com.dbclm.nace.service.NaceDetailsService;

@RestController
@RequestMapping("/nace")
public class NaceDetailsController {
    @Autowired
    private NaceDetailsService naceDetailsService;

    @PostMapping("/putNaceDetails")
    public ResponseEntity<String> saveNaceDetails(@RequestBody NaceDetails naceDetails) {
    	
        naceDetailsService.saveNaceDetails(naceDetails);
        return ResponseEntity.ok("NACE data saved successfully.");
    }

    @GetMapping("getNaceDetails/{code}")
    public ResponseEntity<?> getNaceDetails(@PathVariable String code) {
        Optional<NaceDetails> naceDetails = naceDetailsService.getNaceDetails(code);
        if (naceDetails.isPresent()) {
            return ResponseEntity.ok(naceDetails.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

