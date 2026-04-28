package learning_constructor;

class copy_main{
  String name;
  int id;

  copy_main(String n, int roll){
    name = n;
    id = roll;
  }

  copy_main(copy_main first){
    this.id = first.id;
    this.name = first.name;
  }

  void display(){
    System.out.println(name +"\n"+ id);
  }
  public static void main(String[] args){

    copy_main first = new copy_main("Rabbit", 1006);
    copy_main second = new copy_main(first);

    first.display();
    second.display();
  }
}