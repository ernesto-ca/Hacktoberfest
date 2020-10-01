def plotPoints(cx , cy , X , Y):
    win.plotPixel(cx + X,cy + Y, "blue")
    win.plotPixel(cx - X,cy + Y, "blue")
    win.plotPixel(cx + X,cy - Y, "blue")
    win.plotPixel(cx - X,cy - Y, "blue")
    win.plotPixel(cx + Y,cy + X, "blue")
    win.plotPixel(cx - Y,cy + X, "blue")
    win.plotPixel(cx + Y,cy - X, "blue")
    win.plotPixel(cx - Y,cy - X, "blue")
    
    
#Mid Point Circle Algo
#from graphics import *
win = GraphWin("CG Algorithms", 600, 600)

#text
label = Text(Point(290, 24), 'Mid-Point Circle Algo')
label.setSize(24)
label.draw(win)


#Input points
print("Enter centre point (x,y) -")
cx = int(input())
cy = int(input())
print("Enter radius -")
r = int(input())

X = 0
Y = r

plotPoints(cx , cy , X , Y)

p = 1 - r
while X < Y :
    X+=1
    if p < 0:
        p += 2 * X + 1
    else:
        Y-=1
        p += 2 * (X - Y) + 1
    plotPoints(cx , cy , X , Y)

win.getMouse()
win.close()