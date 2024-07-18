package com.example.kopringjpa.service

import com.example.kopringjpa.domain.Member
import com.example.kopringjpa.dto.MemberReqDto
import com.example.kopringjpa.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(val memberRepository: MemberRepository) : MemberService {

    override fun createMember(memberDto: MemberReqDto) {
        val member = Member(
            name = memberDto.name,
            userId = memberDto.userId,
            password = memberDto.password
        )
        memberRepository.save(member)
    }

}