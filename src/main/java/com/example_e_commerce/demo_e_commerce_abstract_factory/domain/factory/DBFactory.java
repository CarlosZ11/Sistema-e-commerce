package com.example_e_commerce.demo_e_commerce_abstract_factory.domain.factory;

import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.IProductoDB;

public abstract class DBFactory {

    public abstract IProductoDB createDB();

}
