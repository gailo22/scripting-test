def fact(n):

  r=1
  if n==0:
    r==1 
  else: 
    r=n*fact(n-1)

  return r


for i in range(1,9):
	print fact(i),

print ""