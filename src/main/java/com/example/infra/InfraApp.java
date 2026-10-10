package com.example.infra;

import software.amazon.awscdk.App;

public class InfraApp {
    public static void main(String[] args) {
        App app = new App();
        new InfraStack(app, "S3GatewayStack");
        app.synth();
    }
}
