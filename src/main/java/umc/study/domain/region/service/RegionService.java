package umc.study.domain.region.service;

import umc.study.domain.region.entity.Region;

public interface RegionService {
    boolean existsRegionById(Long id);
    Region findByRegionId(Long id);
}
