package com.importercsv.camelpresentation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ";")
@Jacksonized
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineStock {
    @DataField(pos = 1)
    private Integer id;
    @DataField(pos = 2)
    private String name;
    @DataField(pos = 3)
    private int amount;
    @DataField(pos = 4)
    private int expireDays;
}
