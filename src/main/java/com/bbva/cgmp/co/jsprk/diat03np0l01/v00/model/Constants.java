package com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model;


public class Constants {
    public static final String ORACLE_ALIAS = "oralcleAlias";
    public static final String PERSISTENCE_KEY = "oracle";
    public static final String UUAA = "CGMP";
    public static final String SERVICE_NAME = PERSISTENCE_KEY.concat("." + UUAA + ".").concat("BATCH");
    public static final String SERVICE_NAME_OUTPUT = "bts.CGMP.BATCH";
    public static final String PHISICAL_NAME_OUTPUT = "output-database";
    public static final String OUTPUT_ALIAS = "outputDatabase";
    public static final String SELECT = "SELECT %s FROM CGMP.T_CGMP_MARCA_CLIENTE";
    public static final String DEFAULT_SCHEMA_ORACLE_CGMP = "CGMP";
    public static final String PROPERTY_NAME_SCHEMA_ORACLE_CGMP = "SCHEMA";
    public static final String AUDIT_DATE = "AUDIT_DATE";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_PHYSICAL_TARGET_NAME = "PHYSICAL_NAME_OUTPUT";
    public static final String PROPERTY_PHYSICAL_TARGET_NAME = "CGMP-INFO-MARCA-CLIENTE";
    public static final String RECORD_SEQUENTIAL_ID = "RECORD_SEQUENTIAL_ID";
    public static final String CUSTOMER_ID = "CUSTOMER_ID";
    public static final String CUST_REMOTE_STATUS_MARK_TYPE = "CUST_REMOTE_STATUS_MARK_TYPE";
    public static final String USER_AUDIT_ID = "USER_AUDIT_ID";

    private Constants() {
    }
}
