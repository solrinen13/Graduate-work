package ru.skypro.homework.dto.model_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {

      private String firstName;
      private String lastName;
      /**
       * Номер телефона пользователя в формате +7 (XXX) XXX-XX-XX.
       */
      //@Pattern (regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}")
      private String phone;
}
