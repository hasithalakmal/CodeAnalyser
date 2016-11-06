public class SampleCode4 {
    public void fillSieve() {
        boolean[] primes = null;

        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;  
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

    public boolean isPrime(int n) {
        boolean[] primes = null;                                                    
        return primes[n];
    }
    
    public void getValue(){
        fillSieve();
        System.out.println("hello");
        isPrime(5);
                
    }
}