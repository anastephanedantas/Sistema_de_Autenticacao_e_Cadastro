package projeto.ifsol.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSpringSecurity  extends  WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.antMatchers("/inicio").permitAll()
					.antMatchers("/cadastrarProduto", "/listaProdutos").hasRole("PRODUTORES")
					.antMatchers("/listaProdutosServidores").hasRole("SERVIDORES")
					.anyRequest().authenticated()
					.and().formLogin().permitAll()
					.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/materialize/**", "/style/**");
	}

}
