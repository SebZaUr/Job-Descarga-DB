package com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model;

import com.bbva.lrba.properties.LRBAProperties;


public class Utils {
    private static final LRBAProperties lrbaProperties = new LRBAProperties();


    public static String getPropertySchema() {
        return lrbaProperties.getDefault( Constants.PROPERTY_NAME_SCHEMA_ORACLE_CGMP,Constants.DEFAULT_SCHEMA_ORACLE_CGMP);
    }

    public static String getPropertyPhysicalName() {
        return lrbaProperties.getDefault( Constants.PROPERTY_PHYSICAL_TARGET_NAME ,Constants.DEFAULT_PHYSICAL_TARGET_NAME);
    }

    private Utils() {
    }
}
