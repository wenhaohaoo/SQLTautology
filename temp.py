from sympy import *
x1=symbols('x1')
print(factor(simplify(x1*x1**2)))
print(roots(factor(simplify(x1*x1**2))))
print(diff(factor(simplify(x1*x1**2))))
