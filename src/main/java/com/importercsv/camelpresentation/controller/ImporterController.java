package com.importercsv.camelpresentation.controller;

import com.importercsv.camelpresentation.model.MedicineStock;
import com.importercsv.camelpresentation.service.ImporterService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("importer")
public class ImporterController {

    private final ImporterService importerService;

    private final CamelContext camelContext;

    public ImporterController(ImporterService importerService) throws Exception {
        this.importerService = importerService;
        this.camelContext = new DefaultCamelContext();

        camelContext.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                var bindy = new BindyCsvDataFormat(MedicineStock.class);
                var json = new JacksonDataFormat(MedicineStock.class);

                from("file:Entradas?delay=5s&noop=true")//declara de onde vira as entradas e não as remove da pasta quando processar
                        .log("camel esta trabalhando!!")
                        .unmarshal(bindy)//deserializado o arquivo csv
                        .marshal(json).log("${id},${body}")//serializado o arquivo para json
                        .setHeader("CamelFileName", simple("${file:name.noext}.json"))//adicionando extensão ao final do nome do arquivo importado
                        .to("file:Saidas");
            }
        });
    }

    @PostMapping("/start")
    public ResponseEntity startImport() throws Exception {
        importerService.startImport(camelContext);
        return ResponseEntity.ok().body("Importação realizada com sucesso!");
    }
}
