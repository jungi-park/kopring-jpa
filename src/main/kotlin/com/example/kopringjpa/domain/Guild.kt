package com.example.kopringjpa.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Guild(
    @Id @GeneratedValue val id: Long,
    val name: String,
    @OneToMany(mappedBy = "guild") val member: List<Member>
)