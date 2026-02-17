package com.bbva.cgmp.co.jsprk.diat03np0l01.v00;

import com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model.Constants;
import com.bbva.lrba.spark.test.LRBASparkTest;
import com.bbva.lrba.spark.wrapper.DatasetUtils;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransformerTest extends LRBASparkTest {

    private Transformer transformer;

    @BeforeEach
    void setUp() {
        this.transformer = new Transformer();
    }

    @Test
    void transform_Output() {
        StructType schema = DataTypes.createStructType(
               new StructField[]{
                       DataTypes.createStructField(Constants.RECORD_SEQUENTIAL_ID, DataTypes.StringType, false),
                       DataTypes.createStructField(Constants.CUSTOMER_ID, DataTypes.StringType, false),
                       DataTypes.createStructField(Constants.CUST_REMOTE_STATUS_MARK_TYPE, DataTypes.StringType, false),
                       DataTypes.createStructField(Constants.USER_AUDIT_ID, DataTypes.StringType, false),
                       DataTypes.createStructField(Constants.AUDIT_DATE, DataTypes.StringType, false),


               });
        Row firstRow = RowFactory.create("01", "000001", "S","T048319", "2024-06-01");
        Row secondRow = RowFactory.create("02", "000002", "S","T048319", "2024-06-01");
        Row thirdRow = RowFactory.create("03", "000003", "S","T048319", "2024-06-01");

        final List<Row> listRows = Arrays.asList(firstRow, secondRow, thirdRow);

        DatasetUtils<Row> datasetUtils = new DatasetUtils<>();
        Dataset<Row> dataset = datasetUtils.createDataFrame(listRows, schema);

        final Map<String, Dataset<Row>> datasetMap = this.transformer.transform(new HashMap<>(Map.of(Constants.ORACLE_ALIAS, dataset)));

        assertNotNull(datasetMap);
        assertEquals(1, datasetMap.size());

        Dataset<Row> returnedDs = datasetMap.get(Constants.OUTPUT_ALIAS);

        assertEquals(3, returnedDs.count());

        Row firstReturnedRow = returnedDs.collectAsList().get(0);
        assertEquals("01", firstReturnedRow.getAs(Constants.RECORD_SEQUENTIAL_ID));
        assertEquals("000001", firstReturnedRow.getAs(Constants.CUSTOMER_ID));
        assertEquals("S", firstReturnedRow.getAs(Constants.CUST_REMOTE_STATUS_MARK_TYPE));
        assertEquals("T048319", firstReturnedRow.getAs(Constants.USER_AUDIT_ID));
        assertEquals("2024-06-01", firstReturnedRow.getAs(Constants.AUDIT_DATE));
    }

}