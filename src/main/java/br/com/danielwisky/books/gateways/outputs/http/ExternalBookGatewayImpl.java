package br.com.danielwisky.books.gateways.outputs.http;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.ExternalBookGateway;
import br.com.danielwisky.books.gateways.outputs.http.client.BrasilApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExternalBookGatewayImpl implements ExternalBookGateway {

  private final BrasilApiClient brasilApiClient;

  @Override
  public Book findByIsbn(final String isbn) {
    return brasilApiClient.findBookByIsbn(isbn).toDomain();
  }
}
