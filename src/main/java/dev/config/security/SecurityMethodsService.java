package dev.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import dev.entity.Member;
import dev.repository.MemberRepository;



@Service
public class SecurityMethodsService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public boolean isConnectedUser(Long memberId, UserDetails connectedUser) {
		System.err.println(memberId);
		System.err.println(connectedUser);
		
		
		Member member = memberRepository.findById(memberId).orElse(null);
		return member != null && member.getEmail().equals(connectedUser.getUsername());
	}
}

