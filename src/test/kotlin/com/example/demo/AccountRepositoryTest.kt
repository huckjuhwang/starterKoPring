package com.example.demo

import com.example.demo.entity.Account
import com.example.demo.entity.Member
import com.example.demo.repository.AccountRepository
import com.example.demo.repository.MemberRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.math.BigDecimal
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest
class AccountRepositoryTest {
    @Autowired
    private lateinit var memberRepository: MemberRepository
    @Autowired
    private lateinit var accountRepository: AccountRepository
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @BeforeEach
    fun setUp(){
        var member = memberRepository.save(Member("dante", "dante.98@kakaostyle.com"))
        accountRepository.save(Account(member, "010-1234-5678", BigDecimal.ZERO))
    }

    @Test
    fun `계좌번호로 Account 정보조회`(){
        //given
        println("--------- 계좌번호로 Account 정보 조회 ---------")
        val number = "010-1234-5678"

        //when
        val account: Account? = accountRepository.findByNumber(number)
        println(account!!.number)
        println(number)

        //then
        Assertions.assertNotNull(account)
        Assertions.assertEquals(number, account!!.number)
    }
}
