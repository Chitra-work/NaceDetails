package com.dbclm.nace.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbclm.nace.data.entity.NaceDetails;



public interface NaceDetailsRepository extends JpaRepository<NaceDetails, Long> {
    Optional<NaceDetails> findByCode(String code);
}
