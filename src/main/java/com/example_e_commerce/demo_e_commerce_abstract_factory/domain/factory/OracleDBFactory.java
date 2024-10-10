package com.example_e_commerce.demo_e_commerce_abstract_factory.domain.factory;

import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.IProductoDB;
import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.OracleDB;

public class OracleDBFactory extends DBFactory{

    @Override
    public IProductoDB createDB() {
        return OracleDB.getInstance();
    }

}
