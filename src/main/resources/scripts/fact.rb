def fact(n)
  n.zero? ? 1 : n * fact(n - 1)  
end

(1..8).each{|i|print "#{fact(i)} "}
puts