# Iterative Implementation
def fib(n)
  return 0 if n.zero?

  prv, f = 1 , 1
  t=n.abs - 2
  t.times { prv, f = f, f + prv }
  
  if n < 0
    n+=1
    f*=-1**n 
  else
    f*=1
  end

end

(1..11).each{|i|print "#{fib(i)} "}
puts