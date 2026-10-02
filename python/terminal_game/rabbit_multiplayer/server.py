import socket
import threading


def handle_player(client, address):

    print("Player connected!")
    print("Address:", address)

    client.send("Welcome to Rabbit Game!".encode())

    while True:
        message = client.recv(1024)

        if not message:
            break

        print("Player said:", message.decode())

    print("Player disconnected!")
    client.close()


server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server.bind(("0.0.0.0", 5000))

server.listen()

print("Server is running...")
print("Waiting for players...")


while True:

    client, address = server.accept()

    player_thread = threading.Thread(
        target=handle_player,
        args=(client, address)
    )

    player_thread.start()