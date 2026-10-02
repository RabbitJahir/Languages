import curses


world = [
    "##############################",
    "#............#...............#",
    "#............#...............#",
    "#............#....SSSSS......#",
    "#............#....S...S......#",
    "#.................S..........#",
    "#............#....SSSSS......#",
    "#............#...............#",
    "#............#...............#",
    "#............#...............#",
    "##############################"
]

def draw_shop(screen):
    screen.clear()

    shop_screen = [
        "╔══════════════════════════════════════╗",
        "║          RABBIT GENERAL STORE        ║",
        "╠══════════════════════════════════════╣",
        "║                                      ║",
        "║   1. Apple                    5 coins║",
        "║   2. Bread                   10 coins║",
        "║   3. Potion                  25 coins║",
        "║                                      ║",
        "║                                      ║",
        "║              [Q] Leave               ║",
        "║                                      ║",
        "╚══════════════════════════════════════╝"
    ]

    for y, line in enumerate(shop_screen):
        screen.addstr(y, 0, line)

    screen.refresh()


#-------------------------------

player_x = 9
player_y = 7

#-------------------------------

game_state = "world"

#-------------------------------

shop_entrance_x = 20
shop_entrance_y = 4
#-------------------------------

def can_move_to(x, y):
    tile = world[y][x]

    if tile == "#":
        return False

    if tile == "S":
        return False

    return True

def draw_world(screen):
    for y, row in enumerate(world):
        for x, tile in enumerate(row):

            if x == player_x and y == player_y:
                screen.addch(y, x, "@")
            else:
                screen.addch(y, x, tile)
    if near_shop_entrance():
        screen.addstr(len(world) + 1, 0, "[E] Enter Rabbit Shop")

def near_shop_entrance():
    distance_x = abs(player_x - shop_entrance_x)
    distance_y = abs(player_y - shop_entrance_y)

    if distance_x <= 1 and distance_y <= 1:
        return True

    return False

#####################################################################



def game(screen):
    global player_x, player_y, game_state

    screen.keypad(True)

    while True:

        # =========================
        # WORLD
        # =========================

        if game_state == "world":

            screen.clear()
            draw_world(screen)
            screen.refresh()

            key = screen.getch()

            # Quit the entire game
            if key == ord("q"):
                break

            # Enter shop
            elif key == ord("e") and near_shop_entrance():
                game_state = "shop"
                continue

            # Move up
            elif key == ord("w") or key == curses.KEY_UP:
                new_x = player_x
                new_y = player_y - 1

                if can_move_to(new_x, new_y):
                    player_x = new_x
                    player_y = new_y

            # Move down
            elif key == ord("s") or key == curses.KEY_DOWN:
                new_x = player_x
                new_y = player_y + 1

                if can_move_to(new_x, new_y):
                    player_x = new_x
                    player_y = new_y

            # Move left
            elif key == ord("a") or key == curses.KEY_LEFT:
                new_x = player_x - 1
                new_y = player_y

                if can_move_to(new_x, new_y):
                    player_x = new_x
                    player_y = new_y

            # Move right
            elif key == ord("d") or key == curses.KEY_RIGHT:
                new_x = player_x + 1
                new_y = player_y

                if can_move_to(new_x, new_y):
                    player_x = new_x
                    player_y = new_y


        # =========================
        # SHOP
        # =========================

        elif game_state == "shop":

            draw_shop(screen)

            key = screen.getch()

            # Leave shop
            if key == ord("q"):
                game_state = "world"
                continue

            
        


curses.wrapper(game)