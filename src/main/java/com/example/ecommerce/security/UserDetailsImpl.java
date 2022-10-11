package com.example.ecommerce.security;

import com.example.ecommerce.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private Long id;

    private String username;
    private String password;
    private Collection<?extends GrantedAuthority > authorities;

    public UserDetailsImpl(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl create(User user){
        List<GrantedAuthority> authorityList= new ArrayList<>();
        user.getRoles().forEach(role -> authorityList.add(new SimpleGrantedAuthority(role.getName())));
        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(),authorityList);

    }





    @Override
    public String getUsername() {
        return username;
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
        return true;
    }
}
