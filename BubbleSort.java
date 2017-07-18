package test;

public class BubbleSort {

	public static void main(String[] args) {

		int [] array1 = {5,4,3,2,1,11,33,77,-7,-333,67,5555,1,0,1234,7654,0,1,12};
		                 
		bubbleSort(array1);
		displayArray(array1);
		reverseSort(array1);
		displayArray(array1);

	}

	private static void reverseSort(int[] array1) {
		// TODO Auto-generated method stub
		
	}

	private static void displayArray(int[] array) {

		for (int i=0; i<array.length; i++){
			System.out.println(array[i]);
			
		}
		
	}

	private static void bubbleSort(int[] array) {
		
		int temp;
		for (int i=0; i<array.length-1; i++){
			for (int j=0; j<array.length-1; j++){
				if (array[j] > array[j+1]){
					temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
	}

}
