package com.example.kopringjpa.auth.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {
    private val expirationTime = 60 * 60 * 1000 // 1시간
    private val secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512)

    fun generateToken(username: String): String {
        val claims: Claims = Jwts.claims().setSubject(username)
        val now = Date()
        val expiryDate = Date(now.time + expirationTime)

        // JWT 토큰 생성
        val token = Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(secretKey, SignatureAlgorithm.HS512) // 새로운 방식으로 서명
            .compact()

        // "Bearer " 접두사 붙여서 반환
        return "Bearer $token"
    }

    fun validateToken(token: String, username: String): Boolean {
        val claims: Claims = extractClaims(token)
        val tokenUsername = claims.subject
        return (tokenUsername == username && !isTokenExpired(claims))
    }

    fun extractClaims(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token.replace("Bearer ", ""))
            .body
    }

    private fun isTokenExpired(claims: Claims): Boolean {
        return claims.expiration.before(Date())
    }
}