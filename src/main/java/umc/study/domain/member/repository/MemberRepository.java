package umc.study.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
