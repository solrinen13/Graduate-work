package ru.skypro.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Класс, описывающий объявление
 */
@Entity // сущность
@Table (name = "ad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ad {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "author_id", nullable = false)
      private User author;

      @OneToOne()
      @JoinColumn(name = "image_id")
      private Image image;

      @Column(name = "price")
      private Integer price;

      @Column(name = "title")
      private String title;

      @Column(nullable = false)
      private String description;

}
