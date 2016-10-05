package com.liulangf.recursion.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * function gcd is:
 * input: integer x, integer y such that x >= y and y >= 0
 *     1. if y is 0, return x
 *      2. otherwise, return [ gcd( y, (remainder of x/y) ) ]
 *  end gcd
 *  
 *  x%y = remainder of x/y.
 *  gcd(x,y) = gcd(y, x%y)
 *  gcd(x,0) = x;
 * 
 * @author YuQing Liu
 */
public class GreatestCommonDivisor {
	
	private static final transient Logger LOGGER = LoggerFactory.getLogger(GreatestCommonDivisor.class);
	
	int gcd(int x, int y) {
		LOGGER.info("gcd({}, {})", x, y);
		if (y == 0) {
			return x;
		}
		
		return gcd(y, x%y);
	}
	
    /**
     * From commons-math MathUtils.
     * 
     * <p>
     * Gets the greatest common divisor of the absolute value of two numbers,
     * using the "binary gcd" method which avoids division and modulo
     * operations. See Knuth 4.5.2 algorithm B. This algorithm is due to Josef
     * Stein (1961).
     * </p>
     * Special cases:
     * <ul>
     * <li>The invocations
     * <code>gcd(Integer.MIN_VALUE, Integer.MIN_VALUE)</code>,
     * <code>gcd(Integer.MIN_VALUE, 0)</code> and
     * <code>gcd(0, Integer.MIN_VALUE)</code> throw an
     * <code>ArithmeticException</code>, because the result would be 2^31, which
     * is too large for an int value.</li>
     * <li>The result of <code>gcd(x, x)</code>, <code>gcd(0, x)</code> and
     * <code>gcd(x, 0)</code> is the absolute value of <code>x</code>, except
     * for the special cases above.
     * <li>The invocation <code>gcd(0, 0)</code> is the only one which returns
     * <code>0</code>.</li>
     * </ul>
     *
     * @param p any number
     * @param q any number
     * @return the greatest common divisor, never negative
     * @throws ArithmeticException if the result cannot be represented as a
     * nonnegative int value
     * @since 1.1
     */
    public static int gcd2(final int p, final int q) {
        int u = p;
        int v = q;
        if ((u == 0) || (v == 0)) {
            if ((u == Integer.MIN_VALUE) || (v == Integer.MIN_VALUE)) {
//                throw MathRuntimeException.createArithmeticException(
//                        "overflow: gcd({0}, {1}) is 2^31",
//                        p, q);
            }
            return Math.abs(u) + Math.abs(v);
        }
        // keep u and v negative, as negative integers range down to
        // -2^31, while positive numbers can only be as large as 2^31-1
        // (i.e. we can't necessarily negate a negative number without
        // overflow)
        /* assert u!=0 && v!=0; */
        if (u > 0) {
            u = -u;
        } // make u negative
        if (v > 0) {
            v = -v;
        } // make v negative
        // B1. [Find power of 2]
        int k = 0;
        while ((u & 1) == 0 && (v & 1) == 0 && k < 31) { // while u and v are
                                                            // both even...
            u /= 2;
            v /= 2;
            k++; // cast out twos.
        }
        if (k == 31) {
//            throw MathRuntimeException.createArithmeticException(
//                    "overflow: gcd({0}, {1}) is 2^31",
//                    p, q);
        }
        // B2. Initialize: u and v have been divided by 2^k and at least
        // one is odd.
        int t = ((u & 1) == 1) ? v : -(u / 2)/* B3 */;
        // t negative: u was odd, v may be even (t replaces v)
        // t positive: u was even, v is odd (t replaces u)
        do {
            /* assert u<0 && v<0; */
            // B4/B3: cast out twos from t.
            while ((t & 1) == 0) { // while t is even..
                t /= 2; // cast out twos
            }
            // B5 [reset max(u,v)]
            if (t > 0) {
                u = -t;
            } else {
                v = t;
            }
            // B6/B3. at this point both u and v should be odd.
            t = (v - u) / 2;
            // |u| larger: t positive (replace u)
            // |v| larger: t negative (replace v)
        } while (t != 0);
        return -u * (1 << k); // gcd is u*2^k
    }
	
	public static void main(String...args) {
		LOGGER.info("{}", new GreatestCommonDivisor().gcd(259, 111));
	}
	
}