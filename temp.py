from sympy import *
x1=symbols('x1')
print(factor(simplify(x1*x1-4*x1+4)))
print(roots(factor(simplify(x1*x1-4*x1+4))))
