package no.lundesgaard.forsikring.forsikringsavtale.integrasjon.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtale;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtaletype;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kundenummer;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringasvtaletype;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtale;

import org.junit.jupiter.api.Test;

class AvtaleMapperTest {

    @Test
    void tilAvtale_alt_ok() {
        Kundenummer kundenummer = new Kundenummer("12345678");
        Forsikringsavtale forsikringsavtale = Forsikringsavtale.builder()
                .type(Forsikringasvtaletype.BIL)
                .forsikringssum(200_000)
                .build();
        AvtaleMapper avtaleMapper = new AvtaleMapper();

        Avtale avtale = avtaleMapper.tilAvtale(kundenummer, forsikringsavtale);
        
        assertThat(avtale).isNotNull();
        assertThat(avtale.getKundenummer()).isEqualTo(kundenummer);
        assertThat(avtale.getAvtaletype()).isEqualTo(Avtaletype.BIL);
        assertThat(avtale.getForsikringssum()).isEqualTo(200_000);
    }

    // TODO - legg på test-varianter inkl. data med feil
}
