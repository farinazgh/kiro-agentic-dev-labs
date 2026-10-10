package com.example.infra;

import java.util.List;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.services.ec2.GatewayVpcEndpointAwsService;
import software.amazon.awscdk.services.ec2.GatewayVpcEndpointOptions;
import software.amazon.awscdk.services.ec2.SubnetConfiguration;
import software.amazon.awscdk.services.ec2.SubnetType;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.s3.Bucket;
import software.constructs.Construct;

public class InfraStack extends Stack {
    public InfraStack(Construct scope, String id) {
        super(scope, id);

        Vpc vpc = Vpc.Builder.create(this, "Vpc")
                .maxAzs(2)
                .natGateways(0)
                .subnetConfiguration(List.of(
                        SubnetConfiguration.builder()
                                .name("Isolated")
                                .subnetType(SubnetType.PRIVATE_ISOLATED)
                                .cidrMask(24)
                                .build()))
                .build();

        Bucket.Builder.create(this, "Bucket").build();

        vpc.addGatewayEndpoint("S3GatewayEndpoint",
                GatewayVpcEndpointOptions.builder()
                        .service(GatewayVpcEndpointAwsService.S3)
                        .build());
    }
}
