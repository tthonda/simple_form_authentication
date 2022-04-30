package tthonda.sample.web.data;

import org.springframework.security.core.authority.AuthorityUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginUser extends org.springframework.security.core.userdetails.User {

	private String userId;
	private String password;

	/**
	 * コンストラクタ
	 * 
	 * @param user
	 */
	public LoginUser(String userId, String password) {
		// スーパークラスのユーザーID、パスワードに値をセットする
		// 実際の認証はスーパークラスのユーザーID、パスワードで行われる
		super(userId, password, AuthorityUtils.createAuthorityList("ROLE_USER"));

		this.userId = userId;
		this.password = password;
	}
}