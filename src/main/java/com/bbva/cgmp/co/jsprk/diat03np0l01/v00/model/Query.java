package com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model;


import java.util.List;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.replace;

public class Query {
    public static final String SCHEMA_SEARCH_STRING = "{SCHEMA}";

    private static final List<String> COLUMNS_TABLE = List.of(
            Constants.RECORD_SEQUENTIAL_ID,
            Constants.CUSTOMER_ID,
            Constants.CUST_REMOTE_STATUS_MARK_TYPE,
            Constants.USER_AUDIT_ID,
            Constants.AUDIT_DATE
            );

    public static String buildQuery(){
        return format(Constants.SELECT,String.join(",",COLUMNS_TABLE),operationQuery());
    }

    private static String operationQuery() {
        return replace("",SCHEMA_SEARCH_STRING, Utils.getPropertySchema());
    }

    private Query() {
    }

}
