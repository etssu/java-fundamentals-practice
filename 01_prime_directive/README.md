
# 🧮 Prime Directive

Easy Java console app to find prime numbers and count them using different modes.

## Description

This program is designed to scan numbers and detect prime numbers between them. 
At the end, it prints the total count of prime and composite numbers found.

There are 4 modes:
 - **full** — analyze all numbers between 1 and `endNumber` (inclusive).
 - **odd** — analyze only odd numbers.
 - **custom** — analyze custom number range.
 - **even** — explains why even numbers (except 2) are not prime.

Every composite number will be printed with its factors (e.g.: `Composite: 9 (3 x 3)`).

---

## Usage example
```
Enter mode (full / odd / even / custom) or 'exit': full
Enter end number: 10
=====[SCAN LOG]=====
Analyzing numbers 1 - 10
Number 1 is neither prime nor composite.
Prime number: 2
Prime number: 3
Composite: 4 (2 x 2)
Prime number: 5
Composite: 6 (2 x 3)
Prime number: 7
Composite: 8 (2 x 4)
Composite: 9 (3 x 3)
Composite: 10 (2 x 5)
Total primes found: 4
Total composites found: 5
```

---

## How to run

Compile and run the project with:

```bash
javac Main.java PrimeModes.java
java Main
```

---

## Skills practiced

- Working with **loops** (`for`, `while`) to iterate over number ranges efficiently.
- Using **conditional statements** (`if`, `switch-case`) to handle different program modes and input validation.
- Applying **methods** to avoid repetition (e.g., `isPrime()` method).
- Practicing **input handling** with `Scanner`, including reading both strings and integers, and managing input buffer correctly.

