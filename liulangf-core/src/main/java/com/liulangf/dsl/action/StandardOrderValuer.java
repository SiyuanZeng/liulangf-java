package com.liulangf.dsl.action;

public class StandardOrderValuer implements OrderValuer {
    public int valueAs(int qty, int unitPrice) {
        return unitPrice * qty;
    }
}
