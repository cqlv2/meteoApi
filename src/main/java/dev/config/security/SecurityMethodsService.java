package dev.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import dev.entity.Favorite;
import dev.entity.ForumAnswer;
import dev.entity.ForumComment;
import dev.entity.ForumSubject;
import dev.entity.Member;
import dev.exceptions.RepositoryException;
import dev.repository.FavoriteRepository;
import dev.repository.ForumAnswerRepository;
import dev.repository.ForumCommentRepository;
import dev.repository.ForumSubjectRepository;
import dev.repository.MemberRepository;



@Service
public class SecurityMethodsService {
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private ForumSubjectRepository subjectRepository;
	@Autowired
	private ForumAnswerRepository answerRepository;
	@Autowired
	private ForumCommentRepository commentRepository;
	@Autowired
	FavoriteRepository favoriteRepository;
	
	private Long getConnectedUserId() {
		String userName = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Member m = memberRepository.findByEmail(userName).orElse(null);
		return m.getId();
	}
	
	
	
	public boolean isMySubject(Long id) {
		ForumSubject fs =  subjectRepository.findById(id).orElse(null);
		return fs.getMember().getId()==this.getConnectedUserId();
	}
	
	public boolean isMyAnswer(Long id) {
		ForumAnswer fa =  answerRepository.findById(id).orElse(null);
		return fa.getMember().getId()==this.getConnectedUserId();
	}
	
	public boolean isMyComment(Long id) {
		ForumComment fc =  commentRepository.findById(id).orElse(null);
		return fc.getMember().getId()==this.getConnectedUserId();
	}
	
	public boolean isMyFavorite(Long id) {
		Favorite f =  favoriteRepository.findById(id).orElse(null);
		return f.getMember().getId()==this.getConnectedUserId();
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

