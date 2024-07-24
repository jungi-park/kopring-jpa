package com.example.kopringjpa.member.service

import com.example.kopringjpa.auth.enums.Role
import com.example.kopringjpa.member.domain.Member
import com.example.kopringjpa.member.dto.MemberReqDto
import com.example.kopringjpa.member.repository.MemberRepository
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

    override fun findMemberByUserId(userId: String): Member? {
        return memberRepository.findByUserId(userId)
    }

}