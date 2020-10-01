#Bresenham Algo
#from graphics import *
win = GraphWin("CG Algorithms", 600, 600)

#text
label = Text(Point(290, 24), 'Bresenham Line Algo')
label.setSize(24)
label.draw(win)


#Input points
print("Enter x1, y1, x2, y2 - ")
x0 = int(input())
y0 = int(input())
x1 = int(input())
y1 = int(input())

dx = abs(x1 - x0)
dy = abs(y1 - y0)

p = 2 * dy - dx 
X = 0
Y = 0
xEnd = 0

if x0 > x1:
    X = x1
    Y = y1
    xEnd = x0
else:
    X = x0
    Y = y0
    xEnd = x1
    
win.plotPixel(X,Y, "blue")
while X < xEnd:
    X+=1
    if p < 0 :
        p += (2 * dy)
    else :
        Y+=1
        p += (2 * (dy - dx))
    win.plotPixel(X,Y, "blue")


win.getMouse()
win.close()