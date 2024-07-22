package com.example.kopringjpa.service

import com.example.kopringjpa.common.util.JwtUtil
import com.example.kopringjpa.dto.LoginReqDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil // JWT 토큰 생성 및 검증을 위한 유틸 클래스
) : AuthService {

    override fun login(loginReqDto: LoginReqDto): String {
        val userId = loginReqDto.userId
        val password = loginReqDto.password

        // 인증 시도
        try {
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(userId, password)
            )
        } catch (e: Exception) {
            throw UsernameNotFoundException("Invalid username or password")
        }

        // 인증이 성공하면 JWT 토큰 생성
        val userDetails = userDetailsService.loadUserByUsername(userId)


        // 로그인 시 비밀번호 검증 (필요한 경우)
        if (!passwordEncoder.matches(password, userDetails.password)) {
            throw UsernameNotFoundException("Invalid username or password")
        }

        // userDetails에서 사용자 이름을 추출하여 generateToken에 전달
        return jwtUtil.generateToken(userDetails.username) // JWT 토큰 생성
    }
}