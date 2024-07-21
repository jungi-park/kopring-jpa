package com.example.kopringjpa.repository

import com.example.kopringjpa.domain.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<Board,Long> {
}