package com.example.kopringjpa.service

import com.example.kopringjpa.dto.MemberReqDto

interface MemberService {
    fun createMember(memberDto: MemberReqDto)
}