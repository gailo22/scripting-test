# Analytic Implementation
from math import *
 
def fib(n):
  s = sqrt(5);
  p = (1 + s) / 2;
  q = 1 / p;
  t = p**n + q**n;
  t = t / s;
  return int( t + 0.5 )
 
for i in range(1,12):
  print fib(i),

print ""