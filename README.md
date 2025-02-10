# Dynamic-Fib
An implementation of the Fibonacci sequence using dynamic programming (May-June 2022)

## Description
Generates Fibonacci numbers in an efficient manor by never repeating calculations. It stores completed calculations in a text file that indexes each element.
There's currently no way to input and request a number without manually editing the file, but this could be easily conducted by polling with a Scanner over System.in.

## Possible Improvements
This could be made more efficient by only reading the file once, converting it to a lookup table/array at the outset of the program, then rewriting the file at the conclusion of the program
