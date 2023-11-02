package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;

import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.model_dto.CommentDto;

import ru.skypro.homework.dto.model_dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.mapper.CommentMapper;

import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.security.SecurityCheck;
import ru.skypro.homework.service.CommentService;

import javax.transaction.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация интерфейса CommentService для управления комментариями.
 */
@Log
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

      private final UserRepository userRepository;
      private final CommentRepository commentRepository;
      private final CommentMapper commentMapper;
      private final AdRepository adRepository;
      private final SecurityCheck securityCheck;

      @Override
      public List <CommentDto> getAdComments(Integer id) {
            log.info("Метод получения комментариев");
            List<Comment> allByAdId = commentRepository.findAllByAdId(id);
            return allByAdId.stream()
                    .map(comment -> commentMapper.toCommentDto(comment, comment.getAuthor()))
                    .collect(Collectors.toList());
      }

      @Override
      public CommentDto addCommentToAd(Integer id, CreateOrUpdateCommentDto createOrUpdateCommentDto,
                                     Authentication authentication) {
            User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow();
            Ad ad = adRepository.findById(id).orElseThrow();
            log.info("Был вызван метод для добавления комментария к объявлениюу");
            Comment comment = commentRepository.save(new Comment(ad, user, Instant.now(), createOrUpdateCommentDto.getText()));
            return commentMapper.toCommentDto(comment, user);
      }

      @Override
      public void deleteComment (Integer adId, Integer commentId, Authentication authentication) {
            log.info("Был вызван метод для удаления комментария по идентификатору");
            User user = userRepository.findByEmail(SecurityContextHolder.getContext()
                      .getAuthentication().getName()).orElseThrow();
            Comment comment = commentRepository.findById(commentId).orElseThrow();
            if (securityCheck.isAdmin(user) || securityCheck.isAuthorComment(user, comment)) {
                  commentRepository.delete(comment);
            }
      }

      @Override
      public CommentDto updateComment(Integer adId, Integer commentId,
                                       CreateOrUpdateCommentDto createOrUpdateCommentDto) {
            log.info("Был вызван метод для обновления комментария");
            User user = userRepository.findByEmail(SecurityContextHolder.getContext()
                      .getAuthentication().getName()).orElseThrow();
            Comment comment = commentRepository.findById(commentId).orElseThrow();
            if (securityCheck.isAdmin(user) || securityCheck.isAuthorComment(user, comment)) {
                  comment.setText(createOrUpdateCommentDto.getText());
            } else {
                  throw new RuntimeException();
            }
            return commentMapper.toCommentDto(comment, user);
      }
}
