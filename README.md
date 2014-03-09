ArrayHopper
===========

ArrayHopper

Given an array of integers (to be read from file specified in commandline argument), start from indices 0. The value at indices determines how many indices hop we can take. Suppose value at indices 0 is 5, then we can hop from indices 1 to 5. We need to pass through array in minimum number of hops.

Example, array is 5 6 0 4 2 4 1 0 0 4
Output would be: 0, 5, 9, out

if end of array cannot be reached, output "failure"
