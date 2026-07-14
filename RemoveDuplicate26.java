
//26. Remove Duplicates from Sorted Array

public class RemoveDuplicate26 {

   static int removeDuplicate( int arr[]) {
         int i = 0 ;
        for( int j = 1; j < arr.length; j++ ) {
             if( arr[i] < arr[j]  ) {
                i++;
                arr[i] = arr[j];
             };
        };
             return i + 1;
    }


    public static void main( String arg[]) {
  
        int arr [] = {0,1,1,1,2,2,3};
         System.out.print(removeDuplicate(arr));
        };
};