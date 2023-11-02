package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.Register;
import ru.skypro.homework.service.AuthService;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterUserController {

    private final AuthService authService;

    @Operation(summary = "Регистрация нового пользователя", responses = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
    })
    @PostMapping()
    public ResponseEntity<Void> register(@RequestBody Register register) {
        authService.register(register);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
