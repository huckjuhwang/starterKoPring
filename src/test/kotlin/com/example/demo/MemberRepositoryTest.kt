package com.example.demo

import com.example.demo.entity.Member
import com.example.demo.repository.MemberRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import javax.persistence.PersistenceContext
import javax.transaction.Transactional
import  org.assertj.core.api.Assertions.*;
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
// testCode에 Transactional이 있으면 모든 작업이 롤백 된다.
@Transactional
@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private lateinit var memberRepository: MemberRepository;

    @BeforeEach
    fun setup(){
    }

    @Test
//    @Rollback(false)
    fun `Main_TEST`() {
        // given
        var name = "dante"

        // when
        var member = memberRepository.save(Member(name, "dante.98@kakaostyle.com"))
        var findMember = member.id?.let { memberRepository.getReferenceById(it) }

        // then
        Assertions.assertThat(member.id).isEqualTo(findMember?.id)
        Assertions.assertThat(member.username).isEqualTo(findMember?.username)
        Assertions.assertThat(member).isEqualTo(findMember)
    }
}