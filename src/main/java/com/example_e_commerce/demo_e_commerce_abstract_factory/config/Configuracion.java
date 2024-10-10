package com.example_e_commerce.demo_e_commerce_abstract_factory.config;

import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.factory.DBFactory;
import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.factory.MySqlDBFactory;
import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.factory.OracleDBFactory;

public class Configuracion {

    public static DBFactory configureAdapterDB (String dbType) {
        if (dbType.equalsIgnoreCase("oracle")) {
            return new OracleDBFactory();
        } else if (dbType.equalsIgnoreCase("mysql")) {
            return new MySqlDBFactory();
        }
        throw new IllegalArgumentException("Tipo de base de datos no soportado.");
    }

}
