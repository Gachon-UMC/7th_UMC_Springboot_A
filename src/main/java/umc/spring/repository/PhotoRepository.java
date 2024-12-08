package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.photo.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}