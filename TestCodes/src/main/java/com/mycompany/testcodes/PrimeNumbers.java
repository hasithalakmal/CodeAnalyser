/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testcodes;

import java.util.Arrays;

/**
 *
 * @author Hasitha Lakmal
 */
public class PrimeNumbers {

    public void fillSieve() {
        boolean[] primes = null;

        Arrays.fill(primes, true);        // assume all integers are prime.
        primes[0] = primes[1] = false;       // we know 0 and 1 are not prime.
        for (int i = 2; i < primes.length; i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

    public boolean isPrime(int n) {
        boolean[] primes = null;
        //ccc = 4 * 5 + 1 * 1 = 21 														
        return primes[n]; //simple, huh?
    }

}
