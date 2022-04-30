package tthonda.sample.web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import tthonda.sample.web.data.LoginUser;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

		log.info("user id=" + loginId);

		// テスト用ユーザ
		return new LoginUser(loginId, encoder.encode("password"));

	}

}