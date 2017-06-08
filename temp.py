from sympy import *
x1=symbols('x1')
print(factor(simplify(x1/x1-(0))))
print(roots(factor(simplify(x1/x1-(0)))))
print(diff(factor(simplify(x1/x1-(0)))))
