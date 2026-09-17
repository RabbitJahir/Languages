import std.stdio;

void main(){
    int number;

    writeln("have a space before %d to not be error-prone, mostly to not have the \n after the input to be stored as garbage value and auto insert in next readf");
    readf(" %d", &number);
}