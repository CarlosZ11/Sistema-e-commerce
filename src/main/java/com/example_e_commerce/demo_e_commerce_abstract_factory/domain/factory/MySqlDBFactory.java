package com.example_e_commerce.demo_e_commerce_abstract_factory.domain.factory;

import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.IProductoDB;
import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.MySqlDB;

public class MySqlDBFactory extends DBFactory{

    @Override
    public IProductoDB createDB() {
        return MySqlDB.getInstance();
    }

}
