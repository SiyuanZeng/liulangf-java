package com.liulangf.pattern.gof.structural.composite;

import java.util.List;

/**
 *
 */
public class Composite implements Component {

    private List<Component> components;
    
    public void addComponent(Component component) {
        components.add(component);
    }
    
    public void operation() {
        for (Component c : components) {
            c.operation();
        }
    }
}
