package com.demo.authdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.authdemo.entity.Personel;

public interface PersonelRepository extends JpaRepository<Personel, Long> {
    List<Personel> findBySicilNoOrAdSoyadContainingIgnoreCase(String sicilNo, String adSoyad);
    @Query("SELECT p FROM Personel p LEFT JOIN FETCH p.room WHERE p.sicilNo LIKE %:query% OR LOWER(p.adSoyad) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Personel> searchPersonelWithRoom(@Param("query") String query);
    
}