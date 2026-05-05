void main(){

  // final is fixed, but final takes memory only when variable is used
  final name = "rabbit";
  print("name: $name");
  // const is fixed, but it is runtime compilated, takes memory even if variable not used
  const age = 22;
  print("age: $age");

}

class Shape{
  //inside a class, final can used as instance variable
  final circle_color = "Red";
  
  // inside a class, const can not be used alone, static is need
  static const circle_size = "123cm";
}