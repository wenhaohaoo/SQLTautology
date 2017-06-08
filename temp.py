from sympy import *
x1=symbols('x1')
print(factor(simplify((x1*x1*x1*x1-2)-(0))))
print(roots(factor(simplify((x1*x1*x1*x1-2)-(0)))))
print(diff(factor(simplify((x1*x1*x1*x1-2)-(0)))))
print(degree(factor(simplify((x1*x1*x1*x1-2)-(0)))))
