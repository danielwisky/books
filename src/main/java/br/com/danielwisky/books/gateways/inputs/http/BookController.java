package br.com.danielwisky.books.gateways.inputs.http;

import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import br.com.danielwisky.books.gateways.inputs.http.resources.request.BookRequest;
import br.com.danielwisky.books.gateways.inputs.http.resources.response.BookResponse;
import br.com.danielwisky.books.gateways.inputs.http.resources.response.ListResponse;
import br.com.danielwisky.books.usecases.CreateBook;
import br.com.danielwisky.books.usecases.FindBook;
import br.com.danielwisky.books.usecases.FindBooks;
import br.com.danielwisky.books.usecases.UpdateBook;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

  private final CreateBook createBook;
  private final UpdateBook updateBook;
  private final FindBook findBook;
  private final FindBooks findBooks;

  @PostMapping
  @Operation(summary = "Create Book")
  @ResponseStatus(CREATED)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Created"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "409", description = "Conflict"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")})
  public BookResponse createBook(@RequestBody @Valid final BookRequest bookRequest) {
    log.debug("create book request: {}", bookRequest);
    return new BookResponse(createBook.execute(bookRequest.toDomain()));
  }

  @PutMapping(value = "/{id}")
  @Operation(summary = "Update Book")
  @ResponseStatus(OK)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Ok"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "409", description = "Conflict"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")})
  public BookResponse updateBook(
      @PathVariable final String id,
      @RequestBody @Valid final BookRequest bookRequest) {
    log.debug("update book request: {} with id: {}", bookRequest, id);
    return new BookResponse(updateBook.execute(id, bookRequest.toDomain()));
  }

  @GetMapping(value = "/{id}")
  @Operation(summary = "Get Book by Id")
  @ResponseStatus(OK)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Ok"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")})
  public BookResponse getBook(@PathVariable final String id) {
    return new BookResponse(findBook.execute(id));
  }

  @GetMapping
  @Operation(summary = "Get All Books")
  @ResponseStatus(OK)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Ok"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")})
  public ResponseEntity<ListResponse<BookResponse>> getBooks(
      @RequestParam(required = false, defaultValue = "0") final int pageNumber,
      @RequestParam(required = false, defaultValue = "20") final int pageSize) {
    final var pageRequest = PageRequest.of(pageNumber, pageSize, DESC, "id");
    return ResponseEntity.ok(
        new ListResponse<>(findBooks.execute(pageRequest).map(BookResponse::new)));
  }
}