package umc.study.domain.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.region.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
