
package test;


public class test {


    public static void main(String[] args) {
        
        String temp ="abcdef 1234567";
        String temp2 ="xyzefg 54321";
        String temp3 ="765xyz";

        System.out.println("The reverse string is: ");
        System.out.println(reverse(temp));
        System.out.println();
        
        System.out.println("The reverse string2 is: ");
        System.out.println(reverse2(temp2));
        System.out.println();
        
        System.out.println("The reverse string3 is: ");
        System.out.println(reverse3(temp3));
        System.out.println();
        
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("got interrupted!");
        }
        
        int num=4;
        System.out.println("The factorial("+num+") is: "+factorial(num));
        System.out.println();
        
        int index=7;
        System.out.println("The fibonaci("+index+") is: "+fibonacci(index));
        System.out.println();
        
        int disk=3;
        int source = 1;
        int aux = 2;
        int dest = 3;
        System.out.println("The tower of hanoi ("+disk+") disks is: ");
        towerOfHanoi(disk, source, dest, aux);
        System.out.println();
        
        int [] aa = {2, 45, 101, 234, 754, 1000, 1231};

        for (int i=0; i < aa.length; i++)
        	System.out.println("Binary search of key " + aa[i] + " is found on index: " + binarySearch(aa, aa[i])); 
        
        System.out.println("Binary search of 0 is found on index: " + binarySearch(aa, 0));
        System.out.println("Binary search of 5 is found on index: " + binarySearch(aa, 5));
        System.out.println("Binary search of 222 is found on index: " + binarySearch(aa, 222));
        System.out.println("Binary search of 1100 is found on index: " + binarySearch(aa, 1100));
        System.out.println("Binary search of 5555 is found on index: " + binarySearch(aa, 5555));
    }
    public static int binarySearch(int[] array, int key) {
/*
 * 
aa = [2, 45, 101, 234, 754, 1000, 1231];

key = 1000;

binarySearch(aa, key); 


Pseudocode:

-calculate low, mid and high index position

-while searching the array
{
-if key matches element of mid index position, return mid position index
else if key is less than element of mid index position, calculate mid and high index position
	break out of loop if low and high index is equal
else if key is greater than element of mid index position, calculate low and mid index position
	break out of loop if low and high index is equal
}
-if key matches element of mid index position, return mid position index
-return -1 if no match

 */
    	int low = 0;
    	int mid = (array.length - 1)/2;
    	int high = array.length - 1;
    	int searchResult = -1;

    	while (searchResult == -1){

    		if (key == array[mid])
    			return mid;
    		else if (key < array[mid]){
    			high = mid - 1;
    			mid = (low + mid - 1)/2;
    			if (low == high)
    				break;
    		}
    		else{
    			low = mid + 1;
    			mid = (mid + 1 + high)/2;
    			if (low == high)
    				break;
    		}				
    	}
		if (key == array[mid])
			return mid;
		
		return searchResult;
	}
    private static void towerOfHanoi(int disk, int source, int dest, int aux) {
/*
move disk from tower1 to tower3 with tower2 as helper.  Move one disk at a time and the bottom disk must always be bigger than the top disk.    	 
 */
    	if (disk==1) 
    	System.out.printf("%d ---> %d%n", source, dest); 

    	else{ 
    	towerOfHanoi(disk-1, source, aux, dest); 
    	System.out.printf("%d ---> %d%n", source, dest); 
    	towerOfHanoi(disk-1, aux, dest, source); 
    	}
    }

	private static int fibonacci(int index) {
/*
Fobonacci series: 0, 1, 1, 2, 3, 5, 8, 13....
base = 0 and 1
thereafter is sum of previous two numbers.
utilize recursive method call.
 */
    	if (index == 0)
    		return 0;
    	else if (index == 1)
    		return 1;
    	else {
    		return fibonacci(index - 1) + fibonacci(index - 2);
    	}
	}
	public static StringBuilder reverse2(String str) {
/*
-loop from end of string to the beginning.
{
	concatenate or append each character
}
-return result
 */
    	StringBuilder temp= new StringBuilder();
    	for (int i=str.length()-1; i>=0; i--)
    	{
    		//StringBuilder offers better performance and takes less memory
    		temp.append(str.charAt(i));
    	}
    	//return temp.toString();
    	return temp;
    }
    public static String reverse3(String str) {
    	char[]strArray = str.toCharArray();
    	String temp="";
    	for (int i=strArray.length-1; i>=0; i--)
    	{
    		//String resulting slower performance and takes more memory
    		temp = temp + strArray[i];
    	}
    	return temp;
    }
    public static String reverse(String str) {
        
    	char[]strArray = str.toCharArray();
        int size = strArray.length-1;
        int halfway = size/2;
        char temp;    

        for (int i=0; i<= halfway; i++)
        {
            temp = strArray[i];
            strArray[i]=strArray[size-i];
            strArray[size-i] = temp;
        }
        return new String(strArray); 
    }
    
    public static int factorial(int x) {
/*
5! = 5*4*3*2*1 = 120
4! = 4*3*2*1 = 24 
utilize recursive method call. 
 */
        if (x <=1)
                return 1;
        else {
            return x*factorial(x-1);
        }
            
    }

}
