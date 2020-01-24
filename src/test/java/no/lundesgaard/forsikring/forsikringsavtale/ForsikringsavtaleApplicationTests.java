package no.lundesgaard.forsikring.forsikringsavtale;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.net.URI;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.Builder;
import lombok.Data;

@SpringBootTest(webEnvironment = DEFINED_PORT, properties = { "server.port=8080" })
class ForsikringsavtaleApplicationTests {
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@ParameterizedTest
	@MethodSource("avtaler")
	void opprettAvtaleForKunder(Avtale avtale) {
		RestTemplate restTemplate = restTemplateBuilder
				.build();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(APPLICATION_JSON);
		HttpEntity<Avtale> avtaleRequest = new HttpEntity<>(avtale, httpHeaders);
		URI baseUri = URI.create("http://localhost:8080");

		ResponseEntity<AvtaleInfo> avtaleInfoEntity = restTemplate.postForEntity(baseUri.resolve("/forsikringsavtaler"), avtaleRequest, AvtaleInfo.class);

		assertThat(avtaleInfoEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		AvtaleInfo avtaleInfo = avtaleInfoEntity.getBody();
		assertThat(avtaleInfo).isNotNull();
		Pattern avtalenummerPattern = Pattern.compile(format("%s-\\d{8}", avtale.getType()));
		assertThat(avtaleInfo.getAvtalenummer()).matches(avtalenummerPattern);
		assertThat(avtaleInfo.getStatus()).isEqualTo("AVTALE_SENDT");
	}

	private static Stream<Arguments> avtaler() {
		return Stream.of(
				arguments(Avtale.builder()
						.kunde(Kunde.builder()
								.fnr("07053944544")
								.navn("Test1 Testesen")
								.addresse("Testveien 1, 1710 Teststad")
								.epost("test1@example.com")
								.telefonnummer("97111111")
								.build())
						.type(AvtaleType.BIL)
						.forsikringssum(200_000)
						.build()),
				arguments(Avtale.builder()
						.kunde(Kunde.builder()
								.fnr("15018618408")
								.navn("Test2 Testesen")
								.addresse("Testveien 2, 1710 Teststad")
								.epost("test2@example.com")
								.telefonnummer("97222222")
								.build())
						.type(AvtaleType.BAT)
						.forsikringssum(100_000)
						.build()),
				arguments(Avtale.builder()
						.kunde(Kunde.builder()
								.fnr("06051864725")
								.navn("Test3 Testesen")
								.addresse("Testveien 3, 1710 Teststad")
								.epost("test3@example.com")
								.telefonnummer("97333333")
								.build())
						.type(AvtaleType.HUS)
						.forsikringssum(6_000_000)
						.build()),
				arguments(Avtale.builder()
						.kunde(Kunde.builder()
								.fnr("27010138049")
								.navn("Test4 Testesen")
								.addresse("Testveien 4, 1710 Teststad")
								.epost("test4@example.com")
								.telefonnummer("97444444")
								.build())
						.type(AvtaleType.INNBO)
						.forsikringssum(1_500_000)
						.build()));
	}
	
	@Data
	private static class AvtaleInfo {
		private String avtalenummer;
		private String status;
	}
	
	@Data
	@Builder
	private static class Avtale {
		private Kunde kunde;
		private AvtaleType type;
		private int forsikringssum;
	}
	
	@Data
	@Builder
	private static class Kunde {
		private String fnr;
		private String navn;
		private String addresse;
		private String epost;
		private String telefonnummer;
	}
	
	private enum AvtaleType {
		BIL, BAT, HUS, INNBO;
	}

}
