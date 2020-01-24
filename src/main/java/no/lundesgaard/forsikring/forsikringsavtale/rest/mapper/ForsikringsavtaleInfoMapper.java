package no.lundesgaard.forsikring.forsikringsavtale.rest.mapper;

import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.ForsikringsavtaleInfo;
import no.lundesgaard.forsikring.forsikringsavtale.rest.ForsikringsavtaleInfoJson;

import org.springframework.stereotype.Component;

@Component
public class ForsikringsavtaleInfoMapper {
    public ForsikringsavtaleInfoJson fromForsikringsavtaleInfo(ForsikringsavtaleInfo forsikringsavtaleInfo) {
        return ForsikringsavtaleInfoJson.builder()
                .avtalenummer(forsikringsavtaleInfo.getForsikringsavtalenummer().getForsikringsavtalenummer())
                .status(forsikringsavtaleInfo.getForsikringsavtaleStatus().name())
                .build();
    }
}
