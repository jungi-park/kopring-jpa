package com.example.kopringjpa.service

import com.example.kopringjpa.dto.LoginReqDto

interface AuthService {
    fun login(loginReqDto: LoginReqDto): String
}