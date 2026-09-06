void main() {
  for (int i = 0; i <= 10; i++) {
    if (i % 2 == 0) {
      print("$i is even");
    }
  }

  //-------------------------------------
  List listItems = ["rabbit", 12];
  print("\n\nPrinting items in List: ");
  for (var item in listItems) {
    print(item);
  }

  //----------------------------------------
  print("\n\nwhile loop: ");
  int j = 0;
  while (j <= 10) {
    print("${j++}");
  }
  //DO while

  //using labels

  outerLoop: for(int i=0;i<10;i++){
    for(int j=i;j<=i;j++){
      print("$j");
      if(j==6){
        break outerLoop;
      }
    }
  }
}
