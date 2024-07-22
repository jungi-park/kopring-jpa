package com.example.kopringjpa.service

import com.example.kopringjpa.common.enums.Status
import com.example.kopringjpa.domain.Member
import com.example.kopringjpa.repository.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val memberRepository: MemberRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val member: Member? = memberRepository.findByUserId(username)
            ?: throw UsernameNotFoundException("User not found with username: $username")

        // member가 null이 아닌 경우에만 접근
        return org.springframework.security.core.userdetails.User(
            member?.userId,  // 이제 member는 non-null 타입이므로 안전하게 접근 가능
            member?.password,
            member?.status == Status.ACTIVE, // 활성 상태일 경우 true
            true, // 계정 만료 여부
            true, // 비밀번호 만료 여부
            true, // 계정 잠금 여부
            member?.authorities() // 권한 설정 메서드
        )
    }
}