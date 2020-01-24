package no.lundesgaard.forsikring.forsikringsavtale.integrasjon.mapper;

import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtale;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtaletype;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kundenummer;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringasvtaletype;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtale;

import org.springframework.stereotype.Component;

@Component
public class AvtaleMapper {
    public Avtale tilAvtale(Kundenummer kundenummer, Forsikringsavtale forsikringsavtale) {
        return Avtale.builder()
                .kundenummer(kundenummer)
                .avtaletype(avtaletypeFra(forsikringsavtale.getType()))
                .forsikringssum(forsikringsavtale.getForsikringssum())
                .build();
    }

    private Avtaletype avtaletypeFra(Forsikringasvtaletype type) {
        return Avtaletype.valueOf(type.name());
    }
}
