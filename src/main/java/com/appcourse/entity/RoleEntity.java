package com.appcourse.entity;

import com.appcourse.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    @Enumerated(value = EnumType.STRING)
    private Role roleName;

    public RoleEntity (Role roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName.name();
    }
}
