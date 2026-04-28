package array;

public class jagged_array {
  public static void main(String a[]){

    //jagged array, known rows, unknown/ dynamic/ different columns.
    int Batch_58[][] = new int[4][];

    Batch_58[0] = new int[3];
    Batch_58[1] = new int[2];
    Batch_58[2] = new int[4];
    Batch_58[3] = new int[1];

    char section = 'A';
    for(int i=0; i<Batch_58.length; i++){
      
      System.out.println(section);
      
      for(int j=0; j<Batch_58[i].length; j++){
        Batch_58[i][j] = (int)(Math.random()*100);  
        System.out.println(Batch_58[i][j] );
      }
      System.out.println();
      section++;
    }
          
  }
}
