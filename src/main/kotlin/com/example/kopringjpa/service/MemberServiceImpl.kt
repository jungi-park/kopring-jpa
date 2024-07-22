package com.example.kopringjpa.service

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
        // 비밀번호 암호화
        val encodedPassword = passwordEncoder.encode(memberDto.password)

        val member = Member(
            name = memberDto.name,
            userId = memberDto.userId,
            password = encodedPassword
        )
        memberRepository.save(member)
    }

    override fun findMemberById(id: Long): Member? {
        return memberRepository.findById(id).getOrNull()
    }

}