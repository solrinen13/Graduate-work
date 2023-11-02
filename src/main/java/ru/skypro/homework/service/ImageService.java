package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Image;

import java.io.IOException;

/**
 * Интерфейс для работы с аватарками пользователя
 */
public interface ImageService {

      /**
       * Загрузка картинки
       * @return {@code Image}
       */
      Image uploadImage (MultipartFile multipartFile) throws IOException;

      /**
       * Получение изображения из базы данных
       * @return {@code byte[]}
       */
      byte[] getImage (Integer imageId);
}
