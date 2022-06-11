package com.example.demo.repository

import com.example.demo.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.PersistenceContext

@Repository
interface MemberRepository : JpaRepository<Member, Long?> {
}