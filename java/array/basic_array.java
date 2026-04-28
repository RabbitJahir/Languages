package array;

public class basic_array {
  public static void main(String[] args){
    float nums[] = {1, 0, 0, 6};

    String names[] = {"Rabbit", "Falcon", "Fox", "Lion"};

    System.out.println(names[0]);
    System.out.println(names[1]);
    System.out.printf("%s\n", names[2]);
    System.out.printf("%s\n\n", names[3]);

    System.out.println(nums[0]);
    System.out.println(nums[1]);
    System.out.printf("%f\n", nums[2]);
    System.out.printf("%.0f\n", nums[3]);

    int dynamic[] = new int[4]; //initially all 0
    
    for(int i=0; i<dynamic.length; i++){
      System.out.printf("\nindex %d = %d",i,  dynamic[i]);
    }
    dynamic[0] = 4; dynamic[1] = 5; dynamic[2] = 10; dynamic[3] = 112312322;
    for(int i=0; i<dynamic.length; i++){
      System.out.printf("\nindex %d = %d",i,  dynamic[i]);
    }

  }
}
