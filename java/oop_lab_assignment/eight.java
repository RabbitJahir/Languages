class test{
  double width_rect = 8, length_rect = 8, radius_circle = 9, rect_area, circle_area;


  void display(){
    rect_area = width_rect*length_rect;
    circle_area = Math.PI*radius_circle*radius_circle;
  
    System.out.println("Area of rectangle of width : " + width_rect + " and length : " + length_rect + " is : " + rect_area + " unit square.");
    System.out.println("Area of circle of radius " + radius_circle + " is : "+circle_area+" unit square.");
  }
}


public class eight {
  public static void main(String[] args){

    test area = new test();
    area.display();
  }
}
