package com.importercsv.camelpresentation.service;

import org.apache.camel.CamelContext;
import org.springframework.stereotype.Service;

@Service
public class ImporterService {



    public void startImport(CamelContext camelContext) throws Exception {
        camelContext.start();
        Thread.sleep(20000);
        camelContext.stop();

    }

}
