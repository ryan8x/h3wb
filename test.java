
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
        
        num=8;
        System.out.println("The fibonaci("+num+") is: "+fibonacci(num));
        System.out.println();
        
        int disk=3;
        int source = 1;
        int aux = 2;
        int dest = 3;
        System.out.println("The tower of hanoi ("+disk+") disks is: ");
        towerOfHanoi(disk, source, aux, dest);
        System.out.println();
    }
    private static void towerOfHanoi(int disk, int source, int aux, int dest) {
    	//need review
		if (disk==1)
	        System.out.printf("%d ---> %d%n", source, dest);
		else{
	        towerOfHanoi(disk-1, source, dest, aux);
	        System.out.printf("%d ---> %d%n", source, dest);
	        towerOfHanoi(disk-1, aux, source, dest);
		}
	
	}
	private static int fibonacci(int num) {
    	if (num == 0)
    		return 0;
    	else if (num == 1)
    		return 1;
    	else {
    		return fibonacci(num - 1) + fibonacci(num - 2);
    	}
	}
	public static StringBuilder reverse2(String str) {
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
        if (x <=1)
                return 1;
        else {
            return x*factorial(x-1);
        }
            
    }

}
