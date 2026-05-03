void main(){

    //var lets dart automatically know the value, var is static
    var auto_number = 12; 
    var name = "rabbit";
    var double_number = 12.23;

    print(auto_number);
    print(name);
    print(double_number);

    // with dynamic, the variable can be changed unlike var (static)
    dynamic change = 12;
    print(change);
    change = "rabbit";
    print(change);


    // if the variables value of var isnt declared, then var becomes dynamic.
    var wtf;

    wtf = 999;
    print(wtf);
    wtf = "wtffff";
    print(wtf);

}