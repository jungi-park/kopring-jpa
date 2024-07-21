package com.example.kopringjpa.service

import com.example.kopringjpa.dto.BoardReqDTO

interface BoardService {
    fun writeBoard(boardDto: BoardReqDTO)
}