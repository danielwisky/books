package br.com.danielwisky.books.gateways.outputs.http.client;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Optional.ofNullable;

import br.com.danielwisky.books.domains.exceptions.BadRequestException;
import br.com.danielwisky.books.domains.exceptions.InternalServerErrorException;
import br.com.danielwisky.books.domains.exceptions.ResourceNotFoundException;
import br.com.danielwisky.books.gateways.outputs.http.client.resources.response.BrasilApiErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class BrasilApiErrorDecoder implements ErrorDecoder {

  private ErrorDecoder errorDecoder = new Default();

  @Override
  @SneakyThrows
  public Exception decode(final String methodKey, final Response response) {
    final var body = IOUtils.toString(response.body().asInputStream(), UTF_8);
    final var errorResponse =
        new ObjectMapper().readValue(body, BrasilApiErrorResponse.class);
    final var message =
        ofNullable(errorResponse).map(BrasilApiErrorResponse::getMessage).orElse(null);

    return switch (response.status()) {
      case 400 -> new BadRequestException(message);
      case 404 -> new ResourceNotFoundException(message);
      case 500 -> new InternalServerErrorException(message);
      default -> errorDecoder.decode(methodKey, response);
    };
  }
}
