package com.example.kopringjpa.member.repository.custom


import com.example.kopringjpa.member.domain.QMember.member
import com.querydsl.jpa.impl.JPAQuery
import com.querydsl.jpa.impl.JPAQueryFactory

class MemberCustomRepositoryImpl (val queryFactory : JPAQueryFactory) : MemberCustomRepository {
    fun select(): JPAQuery<String> {
        return queryFactory.select(member.name).from(member)
    }
}