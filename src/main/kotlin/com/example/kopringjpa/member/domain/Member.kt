package com.example.kopringjpa.member.domain

import com.example.kopringjpa.board.domain.Board
import com.example.kopringjpa.common.domain.BaseEntity
import com.example.kopringjpa.auth.enums.Role
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
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) val board: List<Board> = emptyList(),
    @Enumerated(EnumType.STRING) val role: Role // 하나의 Role만 가지도록 변경
) : BaseEntity() {
    fun authorities(): List<GrantedAuthority> {
        return listOf(SimpleGrantedAuthority(role.name)) // 기본적으로 USER 권한 부여
    }
}