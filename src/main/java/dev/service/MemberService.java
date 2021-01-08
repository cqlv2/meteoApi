package dev.service;

import org.springframework.stereotype.Service;

import dev.dto.member.MemberDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Member;
import dev.repository.MemberRepository;

@Service
public class MemberService extends SuperService<Member, MemberRepository, MemberDtoResponse, MemberDtoQuery>{

}
