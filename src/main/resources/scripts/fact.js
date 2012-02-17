function fact(n) {
    return n == 0 ? 1 : n * fact(n - 1);
}

for (i=1; i < 9; i ++){print(fact(i)+" ");}
println("");