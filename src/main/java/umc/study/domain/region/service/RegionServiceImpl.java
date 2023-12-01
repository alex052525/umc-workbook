package umc.study.domain.region.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.region.entity.Region;
import umc.study.domain.region.repository.RegionRepository;
import umc.study.global.apipayload.code.status.ErrorStatus;
import umc.study.global.exception.GeneralException;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;

    @Override
    public boolean existsRegionById(Long id) {
        return regionRepository.existsById(id);
    }

    @Override
    public Region findByRegionId(Long id) {
        return regionRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));
    }
}
