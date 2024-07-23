package com.example.kopringjpa.auth.service

import com.example.kopringjpa.auth.dto.LoginReqDto

interface AuthService {
    fun login(loginReqDto: LoginReqDto): String
}