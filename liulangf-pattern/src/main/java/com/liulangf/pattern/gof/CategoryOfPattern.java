package com.liulangf.pattern.gof;

public interface CategoryOfPattern {
    
    interface Creational_Patterns {
        void factory_method();
        void abstract_factory();
        void builder();
        void object_pool();
        void singleton();
        void prototype();
    }

    /**
     * 结构型模式研究的是如何组合对象和类类构成更大的结构。
     */
    interface Structure_Patterns {
        void adapter();
        void bridge();
        void composite();
        void decorator();
        void facade();
        void flyweight();
        void proxy();
        void private_class_data();//??
    }
    
    interface Behavioral_Patterns {
        void chain_of_responsibility();
        void command();
        void interpreter();
        void iterator();
        void mediator();
        void memento();
        void null_object();
        void observer();
        void state();
        void strategy();
        void template_method();
        void visitor();
    }

}
