package dts.com.login.config;

import dts.com.login.service.impl.DataAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//@ComponentScan(basePackages = {"com.baeldung.security"})
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataAuthService dataLService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.headers().disable();
//        http.httpBasic().authenticationEntryPoint(new AuthenticationEntryPoint(){
//
//            @Override
//            public void commence(HttpServletRequest request, HttpServletResponse response,
//                                 AuthenticationException authException) throws IOException, ServletException {
//                response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
//
//            }
//
//        });

        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/login", "/all", "/user").permitAll() // Cho phép  truy cập vào  địa chỉ này
                .antMatchers("/v3/api-docs/**",
                             "/swagger-ui/**", "/swagger-ui.html").permitAll()
                .anyRequest().authenticated().and().formLogin().permitAll();// Tất cả các request khác đều cần phải xác thực mới
        // được truy cập

//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(dataLService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors()
//                .and()
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/api/login", "/all", "/creat").permitAll() // Cho phép  truy cập vào  địa chỉ này
//                .antMatchers("/v3/api-docs/**",
//                             "/swagger-ui/**", "/swagger-ui.html").permitAll()
//                .anyRequest().authenticated().and().formLogin().permitAll();// Tất cả các request khác đều cần phải xác thực mới
//        // được truy cập
//
//    }
}
