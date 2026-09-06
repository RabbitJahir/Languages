void main() {
  Continents("Asia", "Africa", "North America");

// named parameter, easily understandable
  Info(name: "w", age: 12, mobile: 0189, address: "tree top", university: "UITS");
}
// [ ], this tells the compiler that three is optional, user may or may not pass it.
// Optionl parameter, if no value is given inside [ ], the compiler will return null.
// only works from right to left, all optional must be inside same bracket

void Continents(one, two, [three, four = "Unknown"]) {
  print("Continents: $one, $two, $three, $four");
}

//  nmed parameter, no sequence needed
void Info({name, age, university, address, mobile}){
  print("Name: $name\nAge: $age\nmobile: $mobile, Address : ${address},");
}