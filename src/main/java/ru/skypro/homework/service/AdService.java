package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.model_dto.AdDto;
import ru.skypro.homework.dto.model_dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.model_dto.ExtendedAdDto;
import java.util.List;


public interface AdService {
      /**
       * Получение списка всех объявлений
       * @return {@code List<AdDto>}
       */
      List<AdDto> getAllAds ();

      /**
       * Добавление обЪявления
       *<p>
       * Добавлять может только зарегестрированный пользователь
       * @return {@code AdDto}
       */
      AdDto addAd (CreateOrUpdateAdDto createOrUpdateAdDto , MultipartFile image);

      /**
       * Получение информации об объявлении
       * @return {@code ExtendedAdDto}
       * @param id идентификатор объявления, не может быть {@code null}.
       */
      ExtendedAdDto getAdInformation (Integer id);

      /**
       * Удаление объявления с комментарием по его идентификатору из базы данных
       *<p> Может быть сделано автором объявления и админом
       * @param id идентификатор объявления, не может быть {@code null}.
       */
      void deleteAd (Integer id , Authentication authentication);

      /**
       * Обновление объявления
       *<p> Обновлять может только автор объявления или админ
       * @return {@code AdDto}
       */
      AdDto updateAdInformation (Integer id , CreateOrUpdateAdDto createOrUpdateAdDto ,
                                 Authentication authentication);

      /**
       * Получения объявлений авторизованного пользователя
       * @return {@code List<AdDto>}
       */
      List<AdDto> getAuthorizedUserAds (Authentication authentication);

      /**
       * Обновление картинки объявления
       */
      void updateImageAd (Integer adsId , MultipartFile imageFile, Authentication authentication) throws Exception;
}




