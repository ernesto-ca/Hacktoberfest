import pygame

# games initial
pygame.init()
# create game screen
screen = pygame.display.set_mode((400, 300))
# create game frame rate
clock = pygame.time.Clock()

done = False
x = 0
y = 0
color = 0

# create games system
while not done:
    
    # create games event
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            done = True

        pressed = pygame.key.get_pressed()
        if pressed[pygame.K_RIGHT]: 
            x += 10
        elif pressed[pygame.K_LEFT]:
            x -= 10
        elif pressed[pygame.K_UP]:
            y -= 30
        elif pressed[pygame.K_DOWN]:
            y += 50

    # clear previous screen 
    screen.fill( (255, 182, 193) )
    # create rectangle 
    pygame.draw.rect(screen, (0, 0, 0), pygame.Rect(x, y, 10, 10))
    pygame.display.flip()
    y += 0.6
    clock.tick(20)