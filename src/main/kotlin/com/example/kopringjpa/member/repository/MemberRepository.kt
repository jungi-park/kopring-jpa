package com.example.kopringjpa.member.repository

import com.example.kopringjpa.member.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    fun findByUserId(username: String): Member?
    
}