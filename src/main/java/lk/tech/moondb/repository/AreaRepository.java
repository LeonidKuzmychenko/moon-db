package lk.tech.moondb.repository;

import lk.tech.moondb.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findByGroupId(Long groupId);
}