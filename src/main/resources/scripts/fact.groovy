def fact(n) {
    return n == 0 ? 1 : n * fact(n - 1);
}

(1..8).each { print "${fact(it)} " }
println ""