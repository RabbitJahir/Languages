Linux 64-bit	GOOS=linux GOARCH=amd64 go build -o chat_linux main.go
Windows 64-bit	GOOS=windows GOARCH=amd64 go build -o chat.exe main.go
Android ARM64	GOOS=android GOARCH=arm64 go build -o main main.go
macOS Intel	GOOS=darwin GOARCH=amd64 go build -o chat_mac main.go
