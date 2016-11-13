package com.bvan.jc.chat4;

import static com.bvan.jc.chat4.Factorial.factorial;
import java.math.BigInteger;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author bvanchuhov
 */
public class FactorialTest {

    @Test
    public void testFactorial_positiveArg3() {
        assertThat(factorial(3), is(BigInteger.valueOf(6)));
    }

    @Test
    public void testFactorial_positiveArg1() {
        assertThat(factorial(1), is(BigInteger.ONE));
    }

    @Test
    public void testFactorial_zeroArg() {
        assertThat(factorial(0), is(BigInteger.ONE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_negativeArg() {
        factorial(-1);
    }

    @Test
    public void testFactorial_positiveArg1000() {
        assertThat(factorial(100).toString(),
                is("9332621544394415268169923885626670049071596826438" +
                        "16214685929638952175999932299156089414639761" +
                        "56518286253697920827223758251185210916864000" +
                        "000000000000000000000")
        );
    }
}
