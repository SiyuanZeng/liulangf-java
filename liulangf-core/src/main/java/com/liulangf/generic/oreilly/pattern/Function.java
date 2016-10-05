package com.liulangf.generic.oreilly.pattern;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Function pattern converts an arbitrary method into an object. 
 * The relation between a function and the corresponding method is similar 
 * to the relation between Comparator and the compareTo method. 
 *
 * Function<A, B, X>, which represents a function. 
 * The class contains an abstract method, apply, that accepts an argument of type A,
 * returns a result of type B, and may throw an exception of type X.
 */
abstract class Function<A,B,T extends Throwable> {
    public abstract B apply(A x) throws T;
    public List<B> applyAll(List<A> list) throws T {
        List<B> result = new ArrayList<B>(list.size());
        for (A x : list) result.add(apply(x));
        return result;
    }
    public static void main (String... args) {
        Function<String,Integer,Error> length =
            new Function<String,Integer,Error>() {
                public Integer apply(String s) {
                    return s.length();
                }
            };
        Function<String,Class<?>,ClassNotFoundException> forName =
            new Function<String,Class<?>,ClassNotFoundException>() {
                public Class<?> apply(String s)
                    throws ClassNotFoundException
                {
                    return Class.forName(s);
                }
            };  
        Function<String,Method,Exception> getRunMethod =
            new Function<String,Method,Exception>() {
                public Method apply(String s)
                    throws ClassNotFoundException,NoSuchMethodException
                {
                    return Class.forName(s).getMethod("run");
                }
            };
        List<String> strings = Arrays.asList(args);
        System.out.println(length.applyAll(strings));

        try { 
        	System.out.println(forName.applyAll(strings));
        } catch (ClassNotFoundException e) { 
        	System.out.println(e); 
        }

        try { 
        	System.out.println(getRunMethod.applyAll(strings)); 
        } catch (ClassNotFoundException e) { 
        	System.out.println(e); 
        } catch (NoSuchMethodException e) { 
        	System.out.println(e); 
        } catch (RuntimeException e) { 
        	throw e; 
        } catch (Exception e) { 
        	assert false; 
        }

    }
}


