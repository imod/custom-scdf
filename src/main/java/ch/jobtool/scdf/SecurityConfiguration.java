package ch.jobtool.scdf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").hasAnyRole("MANAGE", "VIEW", "CREATE", "MODIFY", "DEPLOY", "DESTROY", "SCHEDULE").and().formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user")
				.password("{noop}password")
				.roles("MANAGE", "VIEW", "CREATE", "MODIFY", "DEPLOY", "DESTROY", "SCHEDULE")
				.and()
				.withUser("admin")
				.password("{noop}password")
				.roles("MANAGE", "VIEW", "CREATE", "MODIFY", "DEPLOY", "DESTROY", "SCHEDULE");
	}

}
