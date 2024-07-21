package com.example.kopringjpa.service

import com.example.kopringjpa.domain.Member
import com.example.kopringjpa.dto.MemberReqDto
import java.util.*

interface MemberService {
    fun createMember(memberDto: MemberReqDto)

    fun findMemberById(id:Long): Member?
}