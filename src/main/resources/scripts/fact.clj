(defn fact [x]
  (if (< x 2)
      1
      (* x (fact (dec x)))))
 
(println (fact 10))