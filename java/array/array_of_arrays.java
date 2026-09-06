package array;

public class array_of_arrays{
  public static void main(String a[]){

    // 2D array
    int Batch_58[][] = new int[3][4];

    char section = 'A';

    for(int i=0; i<3; i++){
      System.out.printf("Section %c : \n", section);

      for(int j=0; j<4; j++){
        Batch_58[i][j] = (int)(Math.random()*100);
        System.out.println(Batch_58[i][j] );
      }
      System.out.println();
      section++;
    }

    Batch_58[0][0] = 6;
    Batch_58[0][1] = 5;
    Batch_58[0][2] = 1;
    Batch_58[0][3] = 1; 

    Batch_58[1][0] = 6;
    Batch_58[1][1] = 5;
    Batch_58[1][2] = 1;
    Batch_58[1][3] = 1;

    Batch_58[2][0] = 6;
    Batch_58[2][1] = 5;
    Batch_58[2][2] = 1;
    Batch_58[2][3] = 1;

    for(int n[]: Batch_58){
      for(int m: n){
        System.out.print(m );
      }
      System.out.println("");
    }

  }
}
