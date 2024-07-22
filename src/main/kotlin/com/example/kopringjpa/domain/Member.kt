package com.example.kopringjpa.domain

import com.example.kopringjpa.common.domain.BaseEntity
import com.example.kopringjpa.common.enums.Status
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

@Entity
class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0L,
    val name: String,
    val userId: String,
    val password: String,
    @Enumerated(EnumType.STRING) val status: Status = Status.ACTIVE,
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) val board: List<Board> = emptyList()
) : BaseEntity() {
    fun authorities(): List<GrantedAuthority> {
        return listOf(SimpleGrantedAuthority("ROLE_USER")) // 기본적으로 USER 권한 부여
    }
}