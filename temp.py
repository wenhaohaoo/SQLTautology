from sympy import *
x1,x2,x3=symbols('x1 x2 x3')
print(factor(simplify(x1*(x2%4+3+4*(3+x3)*4/3)+2)))
