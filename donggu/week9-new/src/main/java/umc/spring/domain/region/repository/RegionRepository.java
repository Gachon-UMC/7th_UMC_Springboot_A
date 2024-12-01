package umc.spring.domain.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.region.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

}
