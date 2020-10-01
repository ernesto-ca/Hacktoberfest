/* Program using graphics library */

#include<iostream.h>
#include<conio.h>
#include<graphics.h>
#include<process.h>
#include<dos.h>

void main()
 {
    int gd=DETECT,gm;
    initgraph(&gd,&gm,"c:\\turboc3\\bgi");
    setcolor(RED);
    setfillstyle(SOLID_FILL,RED);
    ellipse(100,260,0,360,90,100);
    floodfill(100,260,RED);
    setcolor(BLACK);
    for(int i=0;i<20;i++)
   {
    setcolor(RED);
    ellipse(80,174,0,240,55,20-i);
    ellipse(40,190,90,290,40,10-i);
   }
    setcolor(BLACK);
    for(i=1;i<15;i++)
    {
     setcolor(BLACK);
     line(90,220+i,140,230+i);
    }
    line(90,235,140,240);
    line(90,220,90,235);
    for(i=0;i<20;i++)
    { setcolor(BLACK);
      line(140,230+i,180,205+i);
    }
    line(140,240,187,220);
   for(i=0;i<100;i++)
   { setcolor(WHITE);
    arc(120,242,165,370,20-i);
    arc(160,233,190,30,17-i);
   }
    setcolor(BLACK);
    setfillstyle(SOLID_FILL,BLACK);
    circle(130,244,5);
    floodfill(130,244,BLACK);
    setfillstyle(SOLID_FILL,BLACK);
    circle(170,232,5);
    floodfill(170,232,BLACK);
    line(120,280,143,250);
    line(143,250,185,260);
    for(i=1;i<15;i++)
    { setcolor(YELLOW);
    line(120+(i+2),280-(2*i),185-(2*i),260-i);
    }
    for(i=1;i<300;i+=2)
    { setcolor(YELLOW);
     arc(155,280+(i+2),180,290+i,35-i);
    }
    line(175,263,165,315);
    for(i=0;i<9;i+=2)
    { setcolor(YELLOW);
     line(120,280+i,165,313+i);
   }
   for(i=0;i<10;i+=2)
   { setcolor(YELLOW);
     line(165+i,265,165,315);
   }
    for(i=374;i<416;i++)
    {setcolor(6);
    arc(120,i,28+i,172-i,60);
    }
    setcolor(8);
    for(i=1;i<7;i++)
    { setcolor(BROWN);
      line(10-i,260,3,230);
    }
    line(3,230,1,250);
    line(1,250,10,260);
    line(10,260,0,260);
    for(i=1;i<10;i++)
    { setcolor(BROWN);
      line(0+i,260,0,280);
    }
    line(0,280,10,260);
    for(i=0;i<30;i++)
    {
      setcolor(12);
     ellipse(80,280,0,360,10-i,20-i);
     ellipse(50,290,0,360,5-i,10-i);
   }

////////////////////ANGRY BOY ////////////////////////////////////////////////

setcolor(RED);
setfillstyle(SOLID_FILL,RED);
ellipse(400,260,0,360,90,100);
floodfill(400,260,RED);
setcolor(BLACK);
    for(i=0;i<20;i++)
   {
     setcolor(RED);
     ellipse(380,174,0,240,55,20-i);
     ellipse(340,190,90,290,40,10-i);
  }
setcolor(LIGHTBLUE);
 for(i=0;i<100;i++)
  {
    ellipse(380,170,0,360,10-i,15);
   }
line(388,160,420,140);
line(420,140,460,190);
 for(i=0;i<75;i+=2)
 {
  line(388,180-i,460,190);
 }
line(380,170,340,140);
line(340,140,340,210);
 for(i=0;i<100;i+=2)
 {
 line(340,210-i,380,170);
 }
  setcolor(BLACK);
  for(i=0;i<13;i++)
  {
   line(360,200+i,400,210+i);
  }
line(360,215,400,220);
line(360,200,360,215);
line(400,210,400,220);
circle(400,250,20);
circle(438,250,18);
line(380,245,457,245);
  for(i=0;i<100;i++)
  { setcolor(WHITE);
    arc(400,247,180,360,20-i);
    arc(438,247,180,360,18-i);
  }
  for(i=0;i<100;i++)
   { setcolor(BLACK);
     circle(400,250,5-i);
     circle(430,250,5-i);
   }
 for(i=0;i<10;i++)
 {
  line(428,220+i,460,210+i);
 }
 for(i=0;i<14;i++)
 {
  setcolor(BLACK);
  line(380-i,245-i,400,245);
 }
line(400,245,370,230);
line(370,230,380,245);
line(440,245,470,230);
line(470,230,457,245);
 for(i=0;i<16;i++)
 {
  setcolor(BLACK);
  line(440+(i*2),245-i,455,245);
 }
line(420,263,380,280);
line(420,263,475,280);
 for(i=0;i<15;i++)
 {  setcolor(YELLOW);
    line(380+(i*3),280-(i*2),475,280);
    setcolor(BLACK);
    line(380,280,475,280);
}
for(i=0;i<15;i++)
 {
    setcolor(YELLOW);
    line(380,282,450-i*2,282+i*2);
}
 line(380,280,420,310);
 line(420,310,450,280);
 for(i=0;i<100;i++)
  { setcolor(12);
    ellipse(360,270,0,360,12-i,16);
    ellipse(482,270,0,360,7-i,10);
  }
 for(i=0;i<50;i++)
 {
   setcolor(6);
   arc(400,400,47,132,90-i);
 }

  setcolor(LIGHTBLUE);
  arc(140,80,90,270,30);
  arc(150,85,190,300,30);
  arc(145,78,360,180,30);
  arc(170,78,360,180,30);
  arc(200,78,360,180,30);
  arc(170,100,170,300,30);
  arc(190,90,260,50,40);
  circle(180,160,15);
  setcolor(RED);
  settextstyle(DEFAULT_FONT,0,2);
  outtextxy(140,80,"Hii !");

  setcolor(LIGHTBLUE);
  arc(540,80,90,270,30);
  arc(550,85,190,300,30);
  arc(545,78,360,180,30);
  arc(570,78,360,180,30);
  arc(600,78,360,180,30);
  arc(570,100,170,300,30);
  arc(590,90,260,50,40);
  circle(540,160,20);
  circle(510,190,10);
  setcolor(RED);
  settextstyle(DEFAULT_FONT,0,2);
  outtextxy(540,80,"Bye !");
  getch();
  }

/* made by Anju Kumari */