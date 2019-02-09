 

/**
 * Created by leon on 1/29/18.
 */
import java.util.*;
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        int arrSize= array.length;
        return array[arrSize-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean exists = false;
        exists = Arrays.asList(array).contains(value);
        if (exists == true)
        return true;
        else
        return false;
        
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        int inputArraySize= array.length;
        int j = 0;
        String[] revString = new String[inputArraySize]; 
        for(int i=inputArraySize-1;i>=0;i--){
            revString[j]= array[i];
            j++;
        }
        
        return revString;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int inputArraySize = array.length;
        int j = 0;
        boolean palindrome = true;
        for(int i=inputArraySize-1;i>=0;i--){
            if(array[i].equalsIgnoreCase(array[j]))
            {    
                 j++;
            }
            else
            {
                palindrome = false;
            }
        }
        
        return palindrome;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String expectedResult = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder actualResult= new StringBuilder();
        String str="";
        
        for(int i=0;i<array.length;i++){
            array[i] = array[i].replaceAll(" ","");
            System.out.println("Copy Array inside for : "+array[i]);
            actualResult.append(array[i]);
            System.out.println("actualResult Array inside for : "+actualResult);
        }
        
        str=actualResult.toString();
        str=str.toLowerCase();
        System.out.println("Output of Str : "+str);
        
        char tempArray[] = str.toCharArray();
        Arrays.sort(tempArray);
        
        String str1 = new String(tempArray);
        System.out.println("Output of Str after sorting : " +str1);
        
        StringBuilder sb = new StringBuilder();
        
        str1.chars().distinct().forEach(c -> sb.append((char) c));
        String str2=sb.toString();
        
        System.out.println("After removing duplicates : "+str2);
        
        
        if(expectedResult.equals(str2))
        {
           return true;
        }
        else
        {
        return false;
        }
        
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int inputArraySize= array.length;
        int numOfOccurrence = 0;
        
        for(int i=0;i<inputArraySize;i++){
         
            if(array[i].equalsIgnoreCase(value)){
                numOfOccurrence++;
            }
            
        }
        
        return numOfOccurrence;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
       
        List<String> arrList= new ArrayList<String>(Arrays.asList(array));
        int indexOfValueRemoved=0;
        
        if (arrList.contains(valueToRemove)){
            indexOfValueRemoved=arrList.indexOf(valueToRemove);
            arrList.remove(indexOfValueRemoved);
        }
        String[] str=(String[])arrList.toArray(new String[arrList.size()]);
        return str;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        List<String> input= new ArrayList<String>(Arrays.asList(array));
        List<String> newList= new ArrayList<String>();
        newList.add(input.get(0));
        
        for(int i=1; i<input.size();i++){
            
            if(input.get(i-1) != input.get(i)){
                newList.add(input.get(i));
            }
            
        }
        
        String[] str=(String[])newList.toArray(new String[newList.size()]);
        return str;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        System.out.println("Inside packConsecutiveDuplicates");
        //List<String> input= new ArrayList<String>(Arrays.asList(array));
        List<String> newList= new ArrayList<String>();
        String str = array[0];
        String previousValue="";
        String currentValue="";
       
        for(int i=1; i<array.length;i++){
            previousValue=array[i-1];
            currentValue=array[i];
           System.out.println("ArrayList value in: "+ " i : "+ i);
            if(previousValue.equals(currentValue)){
                str+=currentValue;
            }
            else if(!previousValue.equals(currentValue))
            {
               newList.add(str); 
               str=currentValue;
               System.out.println(newList);
            
            }
            if(i==(array.length-1)){
            newList.add(str);
            break;
            }
    }
    String[] strArray= new String[newList.size()];
    strArray=newList.toArray(strArray);
    return strArray;
}

    public static void main(String []args){
        
        boolean test = false;
        StringArrayUtils strUtils = new StringArrayUtils();
        
        String[] array = {"The quick brown", "Fox jumps over", "The lazy dog"};
        test= strUtils.isPangramic(array);
        System.out.println("Boolean value : "+test);
        
        
    }
    
}
