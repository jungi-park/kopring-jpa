package com.example.kopringjpa.domain

import com.example.kopringjpa.common.domain.BaseEntity
import com.example.kopringjpa.common.enums.Status
import jakarta.persistence.*

@Entity
class Board(
    @Id @GeneratedValue val id: Long = 0L,
    val title: String,
    var viewCount: Int = 0,
    val category: String,
    @Enumerated(EnumType.STRING) val status: Status = Status.ACTIVE,
    val contents: String,
    @ManyToOne @JoinColumn val member: Member
) : BaseEntity()