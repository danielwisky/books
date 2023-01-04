package br.com.danielwisky.books.domains;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  private String id;
  private String isbn;
  private String title;
  private String subtitle;
  private String publisher;
  private String synopsis;
  private List<String> authors;
  private List<String> images;
  private Integer pageCount;
  private Status status;
  private String errorMessage;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
