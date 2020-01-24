package no.lundesgaard.forsikring.forsikringsavtale.rest.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.ForsikringsavtaleInfo;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.ForsikringsavtaleStatus;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtalenummer;
import no.lundesgaard.forsikring.forsikringsavtale.rest.ForsikringsavtaleInfoJson;

import org.junit.jupiter.api.Test;

class ForsikringsavtaleInfoMapperTest {

    @Test
    void fromForsikringsavtaleInfo_alt_ok() {
        ForsikringsavtaleInfo forsikringsavtaleInfo = ForsikringsavtaleInfo.builder()
                .forsikringsavtalenummer(new Forsikringsavtalenummer("BIL-12345678"))
                .forsikringsavtaleStatus(ForsikringsavtaleStatus.AVTALE_SENDT)
                .build();

        ForsikringsavtaleInfoJson forsikringsavtaleInfoJson = new ForsikringsavtaleInfoMapper().fromForsikringsavtaleInfo(forsikringsavtaleInfo);
        
        assertThat(forsikringsavtaleInfoJson).isNotNull();
        assertThat(forsikringsavtaleInfoJson.getAvtalenummer()).isEqualTo("BIL-12345678");
        assertThat(forsikringsavtaleInfoJson.getStatus()).isEqualTo("AVTALE_SENDT");
    }
}
