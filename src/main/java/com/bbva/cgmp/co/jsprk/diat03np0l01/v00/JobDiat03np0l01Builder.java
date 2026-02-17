package com.bbva.cgmp.co.jsprk.diat03np0l01.v00;

import com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model.Constants;
import com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model.Query;
import com.bbva.cgmp.co.jsprk.diat03np0l01.v00.model.Utils;
import com.bbva.lrba.builder.annotation.Builder;
import com.bbva.lrba.builder.spark.RegisterSparkBuilder;
import com.bbva.lrba.builder.spark.domain.SourcesList;
import com.bbva.lrba.builder.spark.domain.TargetsList;
import com.bbva.lrba.spark.domain.datasource.Source;
import com.bbva.lrba.spark.domain.datatarget.Target;
import com.bbva.lrba.spark.domain.transform.TransformConfig;

@Builder
public class  JobDiat03np0l01Builder extends RegisterSparkBuilder {

    @Override
    public SourcesList registerSources() {
        return SourcesList.builder()
                .add(Source.Jdbc.NativeQuery.builder()
                        .alias(Constants.ORACLE_ALIAS)
                        .serviceName(Constants.SERVICE_NAME)
                        .sql(Query.buildQuery())
                        .build())
                .build();
    }

    @Override
    public TransformConfig registerTransform() {
        return TransformConfig.TransformClass.builder().transform(new Transformer()).build();
    }

    @Override
    public TargetsList registerTargets() {
        return TargetsList.builder()
                .add(Target.File.Csv.builder()
                        .alias(Constants.OUTPUT_ALIAS)
                        .physicalName(Utils.getPropertyPhysicalName())
                        .serviceName(Constants.SERVICE_NAME_OUTPUT)
                        .header(true)
                        .delimiter(";")
                        .build())
                .build();
    }
}