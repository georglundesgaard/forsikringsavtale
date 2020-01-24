package no.lundesgaard.forsikring.forsikringsavtale.rest;

import static java.lang.String.format;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtale;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.ForsikringsavtaleInfo;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.ForsikringsavtaleService;
import no.lundesgaard.forsikring.forsikringsavtale.rest.mapper.ForsikringsavtaleInfoMapper;
import no.lundesgaard.forsikring.forsikringsavtale.rest.mapper.ForsikringsavtaleMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForsikringsavtaleController {
    private final ForsikringsavtaleMapper forsikringsavtaleMapper;
    private final ForsikringsavtaleInfoMapper forsikringsavtaleInfoMapper;
    private final ForsikringsavtaleService forsikringsavtaleService;

    public ForsikringsavtaleController(ForsikringsavtaleMapper forsikringsavtaleMapper,
                                       ForsikringsavtaleInfoMapper forsikringsavtaleInfoMapper,
                                       ForsikringsavtaleService forsikringsavtaleService) {
        this.forsikringsavtaleMapper = forsikringsavtaleMapper;
        this.forsikringsavtaleInfoMapper = forsikringsavtaleInfoMapper;
        this.forsikringsavtaleService = forsikringsavtaleService;
    }

    @PostMapping(path = "/forsikringsavtaler", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ForsikringsavtaleInfoJson> opprettAvtale(@RequestBody ForsikringsavtaleJson forsikringsavtaleJson) {
        Forsikringsavtale forsikringsavtale = forsikringsavtaleMapper.toForsikringsavtale(forsikringsavtaleJson);
        ForsikringsavtaleInfo forsikringsavtaleInfo = forsikringsavtaleService.opprettAvtale(forsikringsavtale);
        ForsikringsavtaleInfoJson forsikringsavtaleInfoJson = forsikringsavtaleInfoMapper.fromForsikringsavtaleInfo(forsikringsavtaleInfo);
        return ResponseEntity.ok(forsikringsavtaleInfoJson);
    }
}
