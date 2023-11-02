package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.model_dto.NewPasswordDto;
import ru.skypro.homework.dto.model_dto.UpdateUserDto;
import ru.skypro.homework.dto.model_dto.UserDto;

import java.io.IOException;

public interface UserService {

    /**
     * Обновление пароля
     */
    void newPassword(NewPasswordDto newPasswordDto ,  Authentication authentication);

    /**
     * Получение информации об авторизованном пользователе
     * @return {UserDto}
     */
    UserDto findAuthUser(Authentication authentication);

    /**
     * Обновление информации об авторизованном пользователе
     * @return {UpdateUserDto}
     */
    UpdateUserDto updateUser(UpdateUserDto updateUserDto , Authentication authentication);

    /**
     * Обновление картинки пользователя
     */
    void updateAvatar(MultipartFile multipartFile , Authentication authentication) throws IOException;
}
