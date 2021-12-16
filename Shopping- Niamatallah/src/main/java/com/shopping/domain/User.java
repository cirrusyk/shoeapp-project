package com.shopping.domain;

import java.util.Collection;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopping.domain.security.Authority;
import com.shopping.domain.security.UserRole;

@Entity
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	//The ID cannot be updatable nor it can be empty
	@Column(name="id", nullable= false, updatable= false)
		private Long id;
		private String username;
		
	@Column(name="email", nullable= false, updatable= false)
		private String email;
		private String password;
		private String confirm_password;
		private boolean enabled= true;
		
		
		@OneToMany(mappedBy = "user", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
		@JsonIgnore
		private Set<UserRole>  userRoles = new HashSet<>();
		
		
		
		
		//generating getters and setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirm_password() {
			return confirm_password;
		}
		public void setConfirm_password(String confirm_password) {
			this.confirm_password = confirm_password;
		}
	
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public Set<UserRole> getUserRoles() {
			return userRoles;
		}
		public void setUserRoles(Set<UserRole> userRoles) {
			this.userRoles = userRoles;
		}
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Set<GrantedAuthority> authorities = new HashSet<>();
			userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
			
			return authorities;
		}
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		
		
		@Override
		public boolean isEnabled() {
			return enabled;
		}
		
		
		
}
