package com.bbva.cgmp.co.jsprk.diat03np0l01.v00;

import com.bbva.lrba.spark.transformers.Transform;
import com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model.RowData;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;

import java.util.HashMap;
import java.util.Map;

public class Transformer implements Transform {

    @Override
    public Map<String, Dataset<Row>> transform(Map<String, Dataset<Row>> datasetsFromRead) {
        Map<String, Dataset<Row>> datasetsToWrite = new HashMap<>();

        Dataset<RowData> dataset = datasetsFromRead.get("sourceAlias1").as(Encoders.bean(RowData.class));
        Dataset<RowData> filteredDataset = dataset.filter(dataset.col("CAMPO2").equalTo("000002"));

        datasetsToWrite.put("targetAlias1", filteredDataset.toDF());

        return datasetsToWrite;
    }

}