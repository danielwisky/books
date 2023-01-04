package br.com.danielwisky.books.gateways.inputs.http;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.danielwisky.books.gateways.inputs.http.resources.request.BookRequest;
import br.com.danielwisky.books.gateways.inputs.http.resources.response.BookResponse;
import br.com.danielwisky.books.usecases.CreateBook;
import br.com.danielwisky.books.usecases.FindBook;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookController {

  private final CreateBook createBook;
  private final FindBook findBook;

  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @Operation(summary = "Create Book")
  @ResponseStatus(CREATED)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Created"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "409", description = "Conflict"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")})
  public BookResponse createSupplier(@RequestBody @Valid final BookRequest bookRequest) {
    log.debug("create book request: {}", bookRequest);
    return new BookResponse(createBook.execute(bookRequest.toDomain()));
  }

  @GetMapping(value = "/{id}")
  @Operation(summary = "Get Book by Id")
  @ResponseStatus(OK)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Ok"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")})
  public BookResponse getSupplier(@PathVariable final String id) {
    return new BookResponse(findBook.execute(id));
  }
}
