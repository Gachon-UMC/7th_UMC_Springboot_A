package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.inquiry.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}