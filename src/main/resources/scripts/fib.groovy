def fib(n) { 
  return n<2 ? n : fib(n-1)+fib(n-2)
}

(1..11).each { print "${fib(it)} " }
println ""