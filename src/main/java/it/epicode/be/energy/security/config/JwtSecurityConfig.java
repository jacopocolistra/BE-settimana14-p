package it.epicode.be.energy.security.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import it.epicode.be.energy.security.service.UserDetailsServiceImpl;
import it.epicode.be.energy.util.AuthTokenFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired UserDetailsServiceImpl userDetailsService;
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Bean public AuthTokenFilter authenticationJwtTokenFilter() { return new
	 * AuthTokenFilter(); }
	 * 
	 * @Override public void configure(AuthenticationManagerBuilder
	 * authenticationManagerBuilder) throws Exception {
	 * authenticationManagerBuilder.userDetailsService(userDetailsService).
	 * passwordEncoder(this.passwordEncoder()); }
	 * 
	 * @Bean public AuthenticationManager authenticationManager() throws Exception {
	 * return super.authenticationManager(); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.headers().frameOptions().sameOrigin().and().csrf().disable().
	 * authorizeRequests().antMatchers("/auth/**")
	 * .permitAll().antMatchers("/public/**")
	 * .permitAll().antMatchers("/api/**").authenticated().and().exceptionHandling()
	 * .authenticationEntryPoint((req, res, ex) ->
	 * res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED : " +
	 * ex.getMessage()))
	 * .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
	 * STATELESS).and() .addFilterBefore(authenticationJwtTokenFilter(),
	 * UsernamePasswordAuthenticationFilter.class); }
	 */

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(1);
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(this.passwordEncoder());
	}

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.headers().frameOptions().sameOrigin().and().csrf().disable().
		 * authorizeRequests() .antMatchers("/auth/**") .permitAll()
		 * .antMatchers("/api/**") .authenticated() .antMatchers("/comuni/**")
		 * .authenticated() .antMatchers("/province/**") .authenticated()
		 * .antMatchers("/indirizzi/**") .authenticated() .antMatchers("/clienti/**")
		 * .authenticated() .and() .formLogin() .permitAll() .and()
		 * 
		 * 
		 * // .exceptionHandling() // .authenticationEntryPoint((req, res, ex) ->
		 * res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED : " +
		 * ex.getMessage())) // .and() .sessionManagement()
		 * //.sessionCreationPolicy(SessionCreationPolicy.STATELESS) .and()
		 * .addFilterBefore(authenticationJwtTokenFilter(),
		 * UsernamePasswordAuthenticationFilter.class);
		 */
		http.csrf().disable().requestMatchers().antMatchers("/api/**").antMatchers("/auth/**")

				.and().authorizeRequests().antMatchers("/auth/**").permitAll().anyRequest().authenticated().and()
				.sessionManagement()

				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

	}

}
