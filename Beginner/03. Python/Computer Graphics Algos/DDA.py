#DDA Algo
#from graphics import *
win = GraphWin("CG Algorithms", 600, 600)

#text
label = Text(Point(290, 24), 'DDA Line Algo')
label.setSize(24)
label.draw(win)


#Input points
print("Enter x1, y1, x2, y2 - ")
x0 = int(input())
y0 = int(input())
x1 = int(input())
y1 = int(input())

dx = x1 - x0 
dy = y1 - y0

steps = max(abs(dx),abs(dy))

incX = dx/steps
incY = dy/steps

X = x0
Y = y0
i = 0 ;
while i < steps:
    win.plotPixel(X,Y, "blue")
    Y = Y + incY
    X = X + incX
    i = i+1


win.getMouse()
win.close()