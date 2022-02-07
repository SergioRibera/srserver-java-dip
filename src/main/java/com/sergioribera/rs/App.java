package com.sergioribera.rs;

import static spark.Spark.*;

public class App {
    public static void main( String[] args ) {
        PProvider propertiesProvider = new PProvider();

        get("/entornos", (req, res) -> "En el ambiente " + propertiesProvider.get("ENVIROMENT"));
    }
}
