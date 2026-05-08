void main(){

  // no double values will be printed, auto removed
  Set<String> continents = Set.from(["Asia", "Antartica", "Asia"]);

  continents.forEach((element) => print(element));
}