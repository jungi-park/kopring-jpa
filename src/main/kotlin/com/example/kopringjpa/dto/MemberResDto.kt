package com.example.kopringjpa.dto

import org.springframework.http.HttpStatus

data class MemberResDto (
    val message:String,
    val status:HttpStatus
)