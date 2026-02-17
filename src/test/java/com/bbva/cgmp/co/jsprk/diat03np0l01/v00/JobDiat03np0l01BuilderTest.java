package com.bbva.cgmp.co.jsprk.diat03np0l01.v00;

import com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model.Constants;
import com.bbva.lrba.builder.spark.domain.SourcesList;
import com.bbva.lrba.builder.spark.domain.TargetsList;
import com.bbva.lrba.spark.domain.datasource.Source;
import com.bbva.lrba.spark.domain.datatarget.Target;
import com.bbva.lrba.spark.domain.transform.TransformConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JobDiat03np0l01BuilderTest {

    private JobDiat03np0l01Builder jobDiat03np0l01Builder;

    @BeforeEach
    void setUp() {
        this.jobDiat03np0l01Builder = new JobDiat03np0l01Builder();
    }

    @Test
    void registerSources_na_SourceList() {
        final SourcesList sourcesList = this.jobDiat03np0l01Builder.registerSources();
        assertNotNull(sourcesList);
        assertNotNull(sourcesList.getSources());
        assertEquals(1, sourcesList.getSources().size());

        final Source source = sourcesList.getSources().get(0);
        assertNotNull(source);
        assertEquals(Constants.ORACLE_ALIAS, source.getAlias());
    }

    @Test
    void registerTransform_na_Transform() {
        //IF YOU WANT TRANSFORM CLASS
        final TransformConfig transformConfig = this.jobDiat03np0l01Builder.registerTransform();
        assertNotNull(transformConfig);
        assertNotNull(transformConfig.getTransform());
    }

    @Test
    void registerTargets_na_TargetList() {
        final TargetsList targetsList = this.jobDiat03np0l01Builder.registerTargets();
        assertNotNull(targetsList);
        assertNotNull(targetsList.getTargets());
        assertEquals(1, targetsList.getTargets().size());

        final Target target = targetsList.getTargets().get(0);
        assertNotNull(target);
        assertEquals(Constants.OUTPUT_ALIAS, target.getAlias());
        assertEquals(Constants.DEFAULT_PHYSICAL_TARGET_NAME, target.getPhysicalName());
    }

}