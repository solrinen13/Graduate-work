package ru.skypro.homework.service;

import ru.skypro.homework.dto.Register;

import javax.servlet.http.HttpServletRequest;

/**
 * Интерфейс сервиса для регистрации пользователя и входа
 */
public interface AuthService {

    /**
     * Авторизация ро логину и паролю
     */
    boolean login(String userName, String password);

    /**
     * Регистрация нового пользователя
     *<p> Для регистрации пользователь заполняет предоставленную форму
     * @return {@code true or false}
     */
    boolean register (Register register);
}
