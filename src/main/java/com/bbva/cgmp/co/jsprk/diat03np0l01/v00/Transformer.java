package com.bbva.cgmp.co.jsprk.diat03np0l01.v00;

import com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model.Constants;
import com.bbva.lrba.spark.transformers.Transform;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.functions;

import java.util.HashMap;
import java.util.Map;

import static org.apache.spark.sql.functions.col;

public class Transformer implements Transform {

    @Override
    public Map<String, Dataset<Row>> transform(Map<String, Dataset<Row>> datasetsFromRead) {
        Map<String, Dataset<Row>> datasetsToWrite = new HashMap<>();

        Dataset<Row> dataset = datasetsFromRead.get(Constants.ORACLE_ALIAS);
        Dataset<Row> datasetSegment = dataset.withColumn(Constants.AUDIT_DATE,
                functions.date_format(col(Constants.AUDIT_DATE),Constants.DATE_FORMAT));
        datasetsToWrite.put(Constants.OUTPUT_ALIAS, datasetSegment.toDF());

        return datasetsToWrite;
    }

}