package com.gmail.queebskeleton.tpgofficeapp.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gmail.queebskeleton.tpgofficeapp.service.impl.JwtProvider;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtProvider jwtProvider;
	private final UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = getJwt(request);
		
		if(StringUtils.hasText(token) && jwtProvider.validateToken(token)) {
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(
					jwtProvider.getUsernameFromToken(token));
			
			UsernamePasswordAuthenticationToken authToken =
					new UsernamePasswordAuthenticationToken(
							userDetails,
							null,
							userDetails.getAuthorities());
			
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(authToken);
			
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	private String getJwt(HttpServletRequest request) {
		
		String bearerToken = request.getHeader("Authorization");
		
		if(bearerToken != null &&
			StringUtils.hasText(bearerToken) &&
			bearerToken.startsWith("Bearer ")) {
			
			return bearerToken.substring(7);
			
		}
		
		return bearerToken;
		
	}

}
