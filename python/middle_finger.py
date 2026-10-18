import turtle

screen = turtle.Screen()
screen.setup(700, 750)
screen.bgcolor("black")
screen.title("Middle Finger - Python Turtle")

t = turtle.Turtle()
t.speed(5)
t.pensize(5)
t.color("white")

def draw_shape(points):
    t.penup()
    t.goto(points[0])
    t.pendown()
    for point in points[1:]:
        t.goto(point)

# Outer hand outline
draw_shape([
    (-100, -280), (-150, -220), (-240, -120),
    (-270, 0), (-250, 50), (-220, 65),
    (-175, 30), (-175, 130), (-135, 170),
    (-75, 170), (-35, 130),
    (-35, 320), (-15, 350), (35, 350),
(55, 320), (55, 130),
    (95, 170), (145, 170), (180, 130),
    (180, -10), (205, 20), (240, 20),
    (270, -10), (285, -120), (250, -210),
    (200, -280), (150, -320), (130, -360),
    (80, -380), (-80, -380), (-130, -360),
    (-150, -320), (-100, -280)
])

# Finger details
draw_shape([
    (-15, 520), (-15, 445), (-5, 425),
    (15, 415), (35, 425), (35, 445), (35, 520)
])

# Finger creases
for y, x1, x2 in [
    (330, -10, 30),
    (210, -10, 30),
    (50, -145, -85),
    (50, 100, 155),
    (5, 205, 245)
]:
    t.penup()
    t.goto(x1, y)
    t.pendown()
    t.goto(x2, y)

t.hideturtle()
turtle.done()
