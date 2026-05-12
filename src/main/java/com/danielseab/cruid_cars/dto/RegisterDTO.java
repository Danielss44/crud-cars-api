package com.danielseab.cruid_cars.dto;

import com.danielseab.cruid_cars.infra.entity.users.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
