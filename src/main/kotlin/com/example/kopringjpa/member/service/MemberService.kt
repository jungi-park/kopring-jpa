package com.example.kopringjpa.member.service

import com.example.kopringjpa.member.domain.Member
import com.example.kopringjpa.member.dto.MemberReqDto

interface MemberService {
    fun createMember(memberDto: MemberReqDto)

    fun findMemberById(id:Long): Member?
}