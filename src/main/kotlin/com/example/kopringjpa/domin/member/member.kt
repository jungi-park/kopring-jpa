package com.example.kopringjpa.domin.member

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class member(@Id @GeneratedValue val id: Long,val name: String)