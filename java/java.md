- WORA

- time java Main.java

- for linux [sudo apt install time]
- /usr/bin/time -v java Main.java

- for linux [sudo apt install hyperfine]
- hyperfine "java Main.java"
- hyperfine --warmup 3 "java Main.java" [does testing 3 times]
- javac Main.java, java Main, then hyeperfine "java Main" [if the code has inputs, hyperfine breaks, ai it, how to hyperfine and send inputs then pipeline java Main]
