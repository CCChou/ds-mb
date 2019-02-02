package ds.web.practice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final static String SQL_QUERY_USER = "SELECT account as username, password as password, true FROM user WHERE account = ?";
	private final static String SQL_QUERY_AUTHORITIES = "SELECT account as username, 'ROLE_USER' FROM user WHERE account = ?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/messageBoard/post")
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery(SQL_QUERY_USER)
			.authoritiesByUsernameQuery(SQL_QUERY_AUTHORITIES)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
