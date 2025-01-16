package com.parking.parkinglot.dto;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.parking.parkinglot.entities.User}
 */
public class UserDto implements Serializable {
    private final Long id;
    @NotEmpty
    private final String username;
    @NotEmpty
    private final String password;
    @NotEmpty
    private final String email;
    private final List<CarDto> cars;

    public UserDto(Long id, String username, String password, String email, List<CarDto> cars) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.cars, entity.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, cars);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "email = " + email + ", " +
                "cars = " + cars + ")";
    }
}