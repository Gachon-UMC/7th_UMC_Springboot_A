package umc.spring.domain.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.reply.domain.Reply;

public interface replyRepository extends JpaRepository<Reply, Long> {
}
