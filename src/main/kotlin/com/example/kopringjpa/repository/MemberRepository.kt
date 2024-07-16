package com.example.kopringjpa.repository

import com.example.kopringjpa.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
}