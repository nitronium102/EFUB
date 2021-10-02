package com.security.testcode.config;

import com.security.testcode.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
	private final UserService userService;
	private String secretKey = "efubisthebest";

	private long tokenValidTime = 30 * 60 * 1000L;

	// 객체 초기화 -> secreteKey를 base64로 encoding
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	// JWT token 생성
	public String createToken(String userPk, String role) { // 이메일과 권한 받음
		Claims claims = Jwts.claims().setSubject(userPk);
		claims.put("roles", role);
		Date now = new Date(); // 현재 시간 -> 유효기간 확인을 위함
		return Jwts.builder()
			.setClaims(claims)
			.setIssuedAt(now)
			.setExpiration(new Date(now.getTime() + tokenValidTime))
			.signWith(SignatureAlgorithm.HS256, secretKey)
			.compact();
	}

	// token 가공해서 정보 추출
	public Authentication getAuthentication(String token) {
		MyUserDetail userDetail = userService.loadUserByUsername(this.getUserPk(token)); // token에서 user의 email 받아옴
		return new UsernamePasswordAuthenticationToken(userDetail, "", userDetail.getAuthorities()); // token으로만 구분 -> credential 필요 X
	}

	public String getUserPk(String token){
		// claim 부분만 parsing -> setSubject로 설정한 이메일 리턴
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	// HTTP 요청 안에서 헤더 찾아서 토큰 가져옴
	public String resolveToken(HttpServletRequest request){
		return request.getHeader("X-AUTH-TOKEN");
	}

	public boolean validateToken(String jwtToken) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
			return !claims.getBody().getExpiration().before(new Date()); // 유효하면 return
		} catch (Exception e){
			return false; //유효하지 않은 경우
		}
	}
}
