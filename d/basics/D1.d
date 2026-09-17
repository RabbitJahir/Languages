import std.stdio;

void main(){
    string hello = "Hello World";
    int yes = 69;
    writeln(hello ," " , yes);

    string pur = "Meow";
    bool shoot = true;

    if(shoot){
        writeln("Shot ", pur);
    }

    int age;

    write("Whats ya age : ");
    readf(" %d", &age);
    if(age%2==0){
        writeln("even seven");
    } else {
        writeln(
            "     odd    bot
        ");
    }
}