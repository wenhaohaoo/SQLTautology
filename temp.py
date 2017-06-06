from sympy import *
x1,x2=symbols('x1 x2')
print(factor(simplify((x1+(x1+3)+3)+(x2*x2*x2*x2*x2/x2/x1))))
