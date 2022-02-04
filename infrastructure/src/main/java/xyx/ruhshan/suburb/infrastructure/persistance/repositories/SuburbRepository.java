package xyx.ruhshan.suburb.infrastructure.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyx.ruhshan.suburb.infrastructure.persistance.entities.SuburbEntity;

import java.util.List;

public interface SuburbRepository extends JpaRepository<SuburbEntity, Long> {
    List<SuburbEntity> findByPostcodeBetween(int start, int end);
}
