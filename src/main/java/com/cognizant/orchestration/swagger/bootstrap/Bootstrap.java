package com.cognizant.orchestration.swagger.bootstrap;

import com.sun.jersey.spi.resource.Singleton;

import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.mule.ApiListingJSON;

@Singleton
public class Bootstrap {
  /** Run on app init by Spring */
  public void start() {
    Info info = new Info()
      .title("Swagger  App")
      .description("This is swagger interface for Booking Engine.").version("1.0.0");

    Swagger swagger = new Swagger().info(info);
    swagger.basePath("/service/swagger");


    ApiListingJSON.init(swagger);
  }
}