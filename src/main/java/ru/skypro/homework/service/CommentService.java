package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.model_dto.CommentDto;
import ru.skypro.homework.dto.model_dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.Comment;

import java.util.List;

/**
 * Сервис для работы с комментариями.
 */

public interface CommentService {

      /**
       * Получения комментариев объявления
       * @return {@code List<CommentDto>}
       */
      List<CommentDto> getAdComments (Integer id);

      /**
       * Добавление комментария к объявлению
       * @return {@code CommentDto}
       */
      CommentDto addCommentToAd (Integer id , CreateOrUpdateCommentDto createOrUpdateCommentDto , Authentication authentication);

      /**
       * Удаление комментария
       */
      void deleteComment (Integer adId , Integer commentId , Authentication authentication);

      /**
       * Обновление комментария
       *<p> Обновлять может только автор комментария или админ
       * @return {@code CommentDto}
       */
      CommentDto updateComment (Integer adId , Integer commentId , CreateOrUpdateCommentDto createOrUpdateCommentDto);
}
