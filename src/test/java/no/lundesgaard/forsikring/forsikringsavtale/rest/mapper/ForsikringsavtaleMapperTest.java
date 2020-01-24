package no.lundesgaard.forsikring.forsikringsavtale.rest.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringasvtaletype;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtale;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtalekunde;
import no.lundesgaard.forsikring.forsikringsavtale.rest.ForsikringsavtaleJson;
import no.lundesgaard.forsikring.forsikringsavtale.rest.ForsikringsavtalekundeJson;

import org.junit.jupiter.api.Test;

class ForsikringsavtaleMapperTest {

    @Test
    void toForsikringsavtale_alt_ok() {
        ForsikringsavtaleJson forsikringsavtaleJson = ForsikringsavtaleJson.builder()
                .kunde(ForsikringsavtalekundeJson.builder()
                        .fnr("08022442822")
                        .navn("Test Testesen")
                        .addresse("Testveien 200, 2000 Teststad")
                        .epost("test@example.com")
                        .telefonnummer("45454545")
                        .build())
                .type("BIL")
                .forsikringssum(300_000)
                .build();
        Forsikringsavtalekunde forsikringsavtalekunde = Forsikringsavtalekunde.builder()
                .fnr("08022442822")
                .navn("Test Testesen")
                .addresse("Testveien 200, 2000 Teststad")
                .epost("test@example.com")
                .telefonnummer("45454545")
                .build();
        
        Forsikringsavtale forsikringsavtale = new ForsikringsavtaleMapper().toForsikringsavtale(forsikringsavtaleJson);
        
        assertThat(forsikringsavtale).isNotNull();
        assertThat(forsikringsavtale.getKunde()).isEqualTo(forsikringsavtalekunde);
        assertThat(forsikringsavtale.getType()).isEqualTo(Forsikringasvtaletype.BIL);
        assertThat(forsikringsavtale.getForsikringssum()).isEqualTo(300_000);
    }
}
