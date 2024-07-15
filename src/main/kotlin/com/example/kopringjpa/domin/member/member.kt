package com.example.kopringjpa.domin.member

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class member(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long, val name: String)