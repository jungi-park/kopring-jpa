package com.example.kopringjpa.service

import com.example.kopringjpa.common.enums.Role
import com.example.kopringjpa.domain.Member
import com.example.kopringjpa.dto.MemberReqDto
import com.example.kopringjpa.repository.MemberRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class MemberServiceImpl(
    val memberRepository: MemberRepository,
    val passwordEncoder: PasswordEncoder,
) : MemberService {

    override fun createMember(memberDto: MemberReqDto) {


        val member = Member(
            name = memberDto.name,
            userId = memberDto.userId,
            password = passwordEncoder.encode(memberDto.password),
            role = Role.ROLE_USER
        )
        memberRepository.save(member)
    }

    override fun findMemberById(id: Long): Member? {
        return memberRepository.findById(id).getOrNull()
    }

}