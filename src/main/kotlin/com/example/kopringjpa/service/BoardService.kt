package com.example.kopringjpa.service

import com.example.kopringjpa.dto.BoardReqDto

interface BoardService {
    fun writeBoard(boardDto: BoardReqDto)
}