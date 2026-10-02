import socket


client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client.connect(("127.0.0.1", 5000))

message = client.recv(1024).decode()

print(message)

while True:

    text = input("> ")

    if text == "quit":
        break

    client.send(text.encode())


client.close()