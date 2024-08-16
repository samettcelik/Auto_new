package com.demo.authdemo.repository;

import com.demo.authdemo.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    @Query("SELECT COUNT(m) FROM Material m WHERE m.room.id = :id")
    int countMaterialsByRoomId(Long id);

    @Query("SELECT COUNT(m) FROM Material m WHERE m.room.id = :id AND m.bulduMu = true")
    int countFoundMaterialsByRoomId(Long id);

    @Query("SELECT COUNT(m) FROM Material m WHERE m.room.id != :id")
    int countMaterialsInOtherLocations(Long id);

    @Query("SELECT m FROM Material m WHERE m.barkodNo = :barkodNo")
    Optional<Material> findByBarkodNo(Long barkodNo);

    // Yeni Sorgu: BarkodNo ile Materyal ve İlişkili Verileri Çekmek
    @Query("SELECT m FROM Material m JOIN FETCH m.room r JOIN FETCH r.subLocation s WHERE m.barkodNo = :barkodNo")
    Optional<Material> findByBarkodNoWithDetails(Long barkodNo);

    @Query("SELECT m FROM Material m WHERE m.personel.per_id = :perId")
    List<Material> findByPersonelPerId(Long perId);

    @Query("SELECT m FROM Material m WHERE m.room.id = :roomId AND m.personel.per_id = :personelId")
    List<Material> findByRoomIdAndPersonelId(Long roomId, Long personelId);

    @Query("SELECT m FROM Material m WHERE m.room.id = :roomId")
    List<Material> findAllByRoomId(Long roomId);

    @Query("SELECT COUNT(m) FROM Material m WHERE m.personel.per_id = :perId AND m.room.id = :roomId AND m.bulduMu = true")
    int countFoundMaterialsByPersonelAndRoom(Long perId, Long roomId);

    @Query("SELECT COUNT(m) FROM Material m WHERE m.personel.per_id = :perId AND m.room.id = :roomId AND m.bulduMu = false")
    int countNotFoundMaterialsByPersonelAndRoom(Long perId, Long roomId);


    @Query("SELECT COUNT(m) FROM Material m WHERE m.personel.per_id = :perId AND m.room.id = :roomId")
    int countTotalMaterialsByPersonelAndRoom(@Param("perId") Long perId, @Param("roomId") Long roomId);

    @Query("SELECT COUNT(m) FROM Material m WHERE m.personel.per_id = :perId AND m.room.id != :roomId")
    int countMaterialsInOtherRoomsByPersonel(@Param("perId") Long perId, @Param("roomId") Long roomId);

    @Query("SELECT m FROM Material m WHERE m.room.id = :roomId AND m.personel.per_id = :perId AND m.barkodNo = :barkodNo")
    Optional<Material> findByRoomIdAndPersonelIdAndBarkodNo(@Param("roomId") Long roomId, 
                                                            @Param("perId") Long perId, 
                                                            @Param("barkodNo") Long barkodNo);
}


