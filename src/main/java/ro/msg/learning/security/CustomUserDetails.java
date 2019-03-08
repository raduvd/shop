package ro.msg.learning.security;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import ro.msg.learning.entity.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by vancer at 3/7/2019
 */
@NoArgsConstructor
@EqualsAndHashCode
public class CustomUserDetails extends User implements UserDetails {

    private List<String> userRoleList;

    public CustomUserDetails(User user, List<String> userRoleList) {
        super(user);
        this.userRoleList = userRoleList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        final String commaDelimitedRoles = StringUtils.collectionToCommaDelimitedString(userRoleList);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(commaDelimitedRoles);
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.getEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.getEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.getEnabled();
    }

    @Override
    public boolean isEnabled() {
        return super.getEnabled();
    }
}
