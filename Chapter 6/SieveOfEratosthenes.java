public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int limit = 1000; // Array size (indices 0-999)
        boolean[] primes = new boolean[limit]; // Array initialized to true

        // Initialize all values as true (assuming they are prime)
        for (int i = 2; i < limit; i++) {
            primes[i] = true;
        }

        // Implement Sieve of Eratosthenes
        for (int p = 2; p * p < limit; p++) {
            if (primes[p]) {
                for (int multiple = p * p; multiple < limit; multiple += p) {
                    primes[multiple] = false; // Mark non-prime multiples
                }
            }
        }

        // Display prime numbers
        System.out.println("Prime numbers between 2 and 999:");
        for (int i = 2; i < 1000; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
