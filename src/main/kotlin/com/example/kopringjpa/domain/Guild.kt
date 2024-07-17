package com.example.kopringjpa.domain

import jakarta.persistence.*

@Entity
class Guild(
    @Id @GeneratedValue val id: Long,
    val name: String,
    @OneToMany(mappedBy = "guild", fetch = FetchType.LAZY) val member: List<Member>
)