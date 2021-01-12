package dev.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import dev.entity.Favorite;
import dev.entity.Member;
import dev.exceptions.RepositoryException;
import dev.repository.MemberRepository;



@Service
public class SecurityMethodsService {
	
	@Autowired
	private MemberRepository memberRepository;

	
	public boolean test(UserDetails u) {
		System.err.println(u.getUsername());
		return false;
	}
	
	
	
	
	
	
	public boolean canRemoveFavorite(Long idFavToRem, UserDetails userD) throws RepositoryException {
		Optional<Member> memberOpt = memberRepository.findByEmail(userD.getUsername());
		if(memberOpt.isPresent()) {
			for (Favorite fav : memberOpt.get().getFavorites()) {
				if(fav.getId().equals(idFavToRem))return true;
			}
			return false;
		}else throw new RepositoryException("email not found");
		
		
		//User u=userRepository.findByEmail(connectedUser.getUsername()).orElseThrow();
	//	return u.getCells().parallelStream().anyMatch(cell-> cell.getId().equals(cellId));
		
		
		
		
	}
	
	
	
	
	public boolean isConnectedUser(Long memberId, UserDetails connectedUser) {
		System.err.println(memberId);
		System.err.println(connectedUser);
		
		
		Member member = memberRepository.findById(memberId).orElse(null);
		return member != null && member.getEmail().equals(connectedUser.getUsername());
	}
}

