package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.skypro.homework.dto.model_dto.CommentDto;
import ru.skypro.homework.dto.model_dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.model.User;

import java.time.Instant;
import java.time.ZoneOffset;

@Mapper (componentModel = "spring")
public interface CommentMapper {

      @Mapping(target = "pk", source = "comment.id")
      @Mapping(target = "author", source = "user.id")
      @Mapping(target = "authorImage", source = "user.image", qualifiedByName = "imageToPathString")
      @Mapping(target = "authorFirstName", source = "user.firstName")
      @Mapping(target = "createdAt", qualifiedByName = "instantToInteger")
      @Mapping(target = "text", source = "comment.text")
      CommentDto toCommentDto(Comment comment, User user);

      @Mapping(target = "id", ignore = true)
      @Mapping(target = "author", ignore = true)
      @Mapping(target = "createdAt", ignore = true)
      @Mapping(target = "ad", ignore = true)
      Comment toComment(CreateOrUpdateCommentDto dto);

      @Named("instantToInteger")
      default long instantToInteger(Instant instant) {
            return instant.atZone(ZoneOffset.ofHours(3)).toInstant().toEpochMilli();
      }

      @Named("imageToPathString")
      default String imageToPathString(Image image) {
            return image != null ? ("/ads/image/" + image.getId()) : null;

      }
}
