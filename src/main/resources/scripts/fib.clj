(defn fib []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(println (apply str (interpose " " (rest (take 12 (fib))))))