function fib(n){
  return n<2 ? n : fib(n-1)+fib(n-2);
}

for (i=1; i <= 11; i++){print(fib(i)+" ");}
println("");