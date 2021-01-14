package dev.config.security;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.entity.Member;
import dev.entity.Role;
import dev.repository.MemberRepository;

@Primary
@Service
@Transactional
public class SecurityUserService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		Set<GrantedAuthority> authorities = findAuthorities(member);
		return new org.springframework.security.core.userdetails.User(username, member.getPassword(), authorities);
	}

	private Set<GrantedAuthority> findAuthorities(Member member) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		Role role = member.getRole();
		if (role != null) {
			if (role.getRights() != null) {
				authorities = role.getRights().stream()
						.map(right -> new SimpleGrantedAuthority(right.getLabel().name())).collect(Collectors.toSet());
			}
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getLabel().name()));
		}
		return authorities;
	}
}