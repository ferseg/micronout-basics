package com.akurey;

import java.io.Serializable;
import java.util.Set;

/**
 * UserInfo
 */
public class UserInfo implements Serializable {

    private String sub;
    private String name;
    private Long iat;
    private Set<String> roles;
    
    public UserInfo() {}

    public UserInfo(String sub, String name, Long iat, Set<String> roles) {
        this.sub = sub;
        this.name = name;
        this.iat = iat;
        this.roles = roles;
    }

    public String getSub() {
        return sub;
    }

    public String getName() {
        return name;
    }

    public Long getIat() {
        return iat;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIat(Long iat) {
        this.iat = iat;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
}
