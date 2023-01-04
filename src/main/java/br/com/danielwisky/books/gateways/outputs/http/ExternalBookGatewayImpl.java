package br.com.danielwisky.books.gateways.outputs.http;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.ExternalBookGateway;
import br.com.danielwisky.books.gateways.outputs.http.client.BrasilApiClient;
import br.com.danielwisky.books.gateways.outputs.http.client.resources.response.BrasilApiBookResponse;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExternalBookGatewayImpl implements ExternalBookGateway {

  private final BrasilApiClient brasilApiClient;

  @Override
  public Optional<Book> findByIsbn(final String isbn) {
    return ofNullable(brasilApiClient.findBookByIsbn(isbn)).map(BrasilApiBookResponse::toDomain);
  }
}
