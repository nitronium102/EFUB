package com.security.testcode.service;

import com.security.testcode.domain.User;
import com.security.testcode.domain.UserRepository;
import com.security.testcode.web.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import com.security.testcode.config.MyUserDetail;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

	private final UserRepository repository;

	// 회원가입 로직 작성
	@Transactional
	public Long joinUser(UserRequestDto user){
		User newUser = User.builder()
						.email(user.getEmail())
						.password(user.getPassword())
						.build();
		repository.save(newUser); // DB에 저장
		return newUser.getUserNum();
	}

	// 기본적인 User Entity 반환
	@Transactional
	public User findUser(UserRequestDto dto){
		User member = repository.findByEmail(dto.getEmail());
		return member;
	}

	@Override
	public MyUserDetail loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email);
		return new MyUserDetail(user);
	}
}
