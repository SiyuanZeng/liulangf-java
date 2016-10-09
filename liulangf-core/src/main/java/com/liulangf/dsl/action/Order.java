
package com.liulangf.dsl.action;

/**
 * Order abstraction that forms the client contract. Note it's immutable and does not contain
 * any setter method. All mutation is handled through the inner <tt>Builder</tt> class.
 * <p/>
 * This is an application of the <em>Builder</em> design pattern that uses fluent interfaces
 * with method chaining.
 */
public class Order {
    static class Builder {
        private String security;
        private int quantity;
        private int limitPrice;
        private boolean allOrNone;
        private int value;
        private String boughtOrSold;

        public Builder() {}

        /**
         * All methods in <tt>Builder</tt> return <tt>this</tt> which helps in method chaining
         * that forms the DSL structures.
         */
        public Builder buy(int quantity, String security) {
            this.boughtOrSold = "Bought";
            this.quantity = quantity;
            this.security = security;
            return this;
        }
        public Builder sell(int quantity, String security) {
            this.boughtOrSold = "Sold";
            this.quantity = quantity;
            this.security = security;
            return this;
        }
        public Builder atLimitPrice(int p) {
            this.limitPrice = p;
            return this;
        }
        public Builder allOrNone() {
            this.allOrNone = true;
            return this;
        }
        public Builder valueAs(OrderValuer ov) {
            this.value = ov.valueAs(quantity, limitPrice);
            return this;
        }
        public Order build() {
            return new Order(this);
        }
    }

    private final String security;
    private final int quantity;
    private final int limitPrice;
    private final boolean allOrNone;
    private int value;
    private final String boughtOrSold;

    private Order(Builder b) {
        security = b.security;
        quantity = b.quantity;
        limitPrice = b.limitPrice;
        allOrNone = b.allOrNone;
        value = b.value;
        boughtOrSold = b.boughtOrSold;
    }

    public boolean isAllOrNone() {
        return allOrNone;
    }

    public String getBoughtOrSold() {
        return boughtOrSold;
    }

    public int getLimitPrice() {
        return limitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSecurity() {
        return security;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
		return new StringBuilder()
		    .append(boughtOrSold)
		    .append(" " + quantity + " shares of ")
		    .append(security)
		    .append(" with limit price ")
		    .append(limitPrice)
		    .append(" ")
		    .append(allOrNone == true ? "ALL OR NONE" : "")
		    .toString();
    }
}
