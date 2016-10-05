package com.liulangf.generic.oreilly.pattern;

/**
 * http://www.javaspecialists.co.za/archive/newsletter.do?issue=123
 * 
 * The Strategy pattern is used to decouple a method from an object, 
 * allowing you to supply many possible instances of the method. 
 * Our discussion of the Strategy pattern illustrates a structuring technique found in many object-oriented programs, 
 * that of parallel class hierarchies. 
 * We will illustrate the Strategy pattern by considering how tax payers may apply different tax strategies. 
 * There will be a hierarchy for tax payers, and a related hierarchy for tax strategies.
 * 
 * Parallel Class Hierarchies A typical use of the Strategy pattern is for tax computation.
 * We have a class TaxPayer with subclasses Person and TRust. 
 * Every tax payer has an income, and, in addition, a trust may be nonprofit.
 * 
 * Before, we used a class TaxPayer and an interface TaxStrategy<P>, 
 * where the type variable P stands for the subclass of TaxPayer to which the strategy applies. 
 * Now we must add the type parameter P to both, 
 * in order that the class TaxPayer<P> can have a field of type TaxStrategy<P>. 
 * The new declaration for the type variable P is necessarily recursive,
 * 
 * In all three cases, the class or interface is the base class of a type hierarchy, 
 * and the type parameter stands for a specific subclass of the base class.
 * Thus, P in TaxPayer<P> stands for the specific kind of tax payer, such as Person or TRust; 
 * just as T in Comparable<T> stands for the specific class being compared, such as String; 
 * or E in Enum<E> stands for the specific enumerated type, such as Season.
 * 
 * The tax payer class contains a field for the tax strategy and a method that passes the tax payer to the tax strategy, 
 * as well as a recursive declaration for P just like the one used in TaxPayer.
 */
abstract class TaxPayer<P extends TaxPayer<P>> {
	
  public long income;  // in cents
  
  /**
   * Self-referential generic types are often used to express in a supertype that its subtypes depend on themselves.
   */
  private TaxStrategy<P> strategy;
  public TaxPayer(long income, TaxStrategy<P> strategy) {
    this.income = income; this.strategy = strategy;
  }
  protected abstract P getThis();
  public long getIncome() { return income; }
  public long computeTax() { 
	  //The problem is that this has type TaxPayer<P>, whereas the argument to computeTax must have type P. 
	  //in fact, this will have the same type as P, but the type system does not know that!
	  //return strategy.computeTax(this); 
	  return strategy.computeTax(getThis()); 
  }
}

interface TaxStrategy<P extends TaxPayer<P>> {
  public long computeTax(P p);
}

class DefaultTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {
  private static final double RATE = 0.40;
  public long computeTax(P payer) {
    return Math.round(payer.getIncome() * RATE);
  }
}

class DodgingTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {
  public long computeTax(P payer) { return 0; }
}

class Person extends TaxPayer<Person> {
  public Person(long income, TaxStrategy<Person> strategy) {
    super(income, strategy);
  }
  protected Person getThis() { return this; }
}

class Trust extends TaxPayer<Trust> {
  private boolean nonprofit;
  public Trust(long income, boolean nonprofit, TaxStrategy<Trust> strategy) {
    super(income, strategy); this.nonprofit = nonprofit;
  }
  protected Trust getThis() { return this; }
  public boolean isNonprofit() { return nonprofit; }
}

class TrustTaxStrategy extends DefaultTaxStrategy<Trust> {
  public long computeTax(Trust trust) {
    return trust.isNonprofit() ? 0 : super.computeTax(trust);
  }
}

class Test {
  public static void main(String[] args) {

    Person person, dodger;
    person = new Person(10000000, new DefaultTaxStrategy<Person>());
    dodger = new Person(10000000, new DodgingTaxStrategy<Person>());
    assert person.computeTax() == 4000000;
    assert dodger.computeTax() == 0;

    Trust forProfit, nonProfit;
    forProfit = new Trust(10000000, false, new TrustTaxStrategy());
    nonProfit = new Trust(10000000, true, new TrustTaxStrategy());
    assert forProfit.computeTax() == 4000000;
    assert nonProfit.computeTax() == 0;
  }
}

