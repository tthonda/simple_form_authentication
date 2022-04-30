package tthonda.sample.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tthonda.sample.web.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and().formLogin()
			.defaultSuccessUrl("/index")
			.usernameParameter("username")
			.passwordParameter("password");
		// @formatter:on
	}

	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		@Autowired
		UserDetailsServiceImpl userDetailsService;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			// 認証するユーザーを設定する
			auth.userDetailsService(userDetailsService)
					// 入力値をbcryptでハッシュ化した値でパスワード認証を行う
					.passwordEncoder(new BCryptPasswordEncoder());

		}
	}
}