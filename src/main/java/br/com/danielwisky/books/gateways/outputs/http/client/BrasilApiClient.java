package br.com.danielwisky.books.gateways.outputs.http.client;

import br.com.danielwisky.books.gateways.outputs.http.client.resources.response.BrasilApiBookResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brasil-api", url = "${external-api.book}")
public interface BrasilApiClient {

  @GetMapping("/isbn/v1/{isbn}")
  BrasilApiBookResponse findBookByIsbn(@PathVariable("isbn") String isbn);

}
