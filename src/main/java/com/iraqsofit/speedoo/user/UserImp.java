package com.iraqsofit.speedoo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iraqsofit.speedoo.models.Media;
import com.iraqsofit.speedoo.models.NotificationModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
public class UserImp implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",insertable = false,updatable = false)
    private int id;
    @Column(name = "username",unique = true)
    @NotEmpty(message = "phone number must be Not Empty")
    @NotNull(message = "phone number must be Not Empty")
    @Pattern(regexp = "^\\d{11}$",message = "phone number must be a 11-digit number")
    @Size(min = 11, max = 11,message = "phone number must be a 11-digit number")
    private String username;

    @Column(name = "name")
    @NotEmpty(message = "name must be Not Empty")
    @NotNull(message = "name must be Not Empty")
    private String name;

    @JsonIgnore
    @Column(name = "password")
    @NotEmpty(message = "password must be Not Empty")
    @NotNull(message = "password must be Not Empty")
    private String password;


    @JsonIgnore
    @Column(name = "is_active")
    private boolean is_active;

    @JsonIgnore
    @Column(name = "otp")
    private String otp;

    @Column(name = "location")
    @NotEmpty(message = "location must be Not Empty")
    @NotNull(message = "location must be Not Empty")
    private String location;

    @Column(name = "city")
    @NotEmpty(message = "city must be Not Empty")
    @NotNull(message = "city must be Not Empty")
    private String city;

    @Column(name = "address")
    @NotEmpty(message = "address  must be Not Empty")
    @NotNull(message = "address  must be Not Empty")
    private String address;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id")
    private List<NotificationModel> notification;


    public UserImp() {
    }

    public UserImp(String name,String username, String password, String location, String city, String address) {
        this.name=name;
        this.username = username;
        this.password = password;
        this.location = location;
        this.city = city;
        this.address = address;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
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
        return this.is_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NotificationModel> getNotification() {
        return notification;
    }

    public void setNotification(List<NotificationModel> notification) {
        this.notification = notification;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
