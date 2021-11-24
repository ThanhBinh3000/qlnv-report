package com.tcdt.qlnvreport.jwt;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tcdt.qlnvreport.table.UserInfo;

import lombok.Data;

@Data
public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;

	UserInfo user;

	public CustomUserDetails(UserInfo user2) {
		this.user = user2;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		return authorities;
	}

	// mac dinh ko check password de la ""
	@Override
	public String getPassword() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode("");
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if (user.getStatus().equals("01")) {
			return true;
		} else {
			return false;
		}
	}

	public long getDvql() {
		return user.getDvql();
	}

}
