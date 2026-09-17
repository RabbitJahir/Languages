import std.stdio;

void main(){

int pizza = 30, coca_cola = 3;
int amount=0,total=0;
int cash_payment=0;

    writeln(
        "
        ____________________
        |                  |
        |      Welcome     |
        | Press any number |
        |    to get it     |
        | 1. Pizza- 30$    |
        | 2. Coca Cola-3$  |
        |__________________|
        "
    );
    
bool loop1 = true;
while(loop1){

int product;
write("Your choice: ");
readf(" %d", &product);

    switch(product){
        case 1:
            
//            while(true){
                write("How many: ");
                readf(" %d", &amount);

                if(amount>0){
                    writeln("Ordered ", amount," pizza's ", pizza, "$ each.");
                        total = amount*pizza;
                    writeln("Total = ", total, "$.");

                    write("Please pay the full amount in cash: ");
                    readf(" %d", &cash_payment);

                    if(cash_payment!=total){
                        writeln("You did not pay the required amount.");
                        loop1=false;
                        break;
                    } else {
                        writeln("Enjoy! :D");
                    }

                } else {
                    break;
                }
   //         }

            
            loop1 = false;
            break;
        default: 
            writeln("Error");
            break;
    }
}
}