use std::io;

fn main() {
    let mut name;
    io::stdin()
        .read(&mut name)
        .parse()
        .trim();
}
