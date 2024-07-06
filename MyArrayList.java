import java.util.Arrays;
class CustomArrayList{
    
// instance variables
    private int size ;
    private Object[] my_array;

// Contructor that will intialise with the given size
	CustomArrayList(int initial_size){
        my_array = new Object[initial_size];
        size= 0;
    }

// constructor that will initialise variables
    CustomArrayList(){
        my_array = new Object[10]; 
        size = 0;
    }
    // add method
	public void add(Object element) {
           my_array[size]= element; 
           size++; //updating the size of the array

        // check if the array size is equal to array length , if so multiply by 2,creating a new array
        if(size==my_array.length-1){
            Object[] added_array = new Object[my_array.length*2];// increased new array

            // copying elements of the first array(my_array) to the second array (added_array)
            for (int i =0;i<my_array.length;i++){
                added_array[i]= my_array[i];
            }
             my_array = added_array ;// so they both refer to the same array
        }
         

    }

	// remove method by index
	public Object remove(int index) throws IndexOutOfBoundsException{
        //swaping the indexes
        
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Given Index "+ index + " actual size "+ size);
        }

        Object removed_element = my_array[index];

         for(int i =index;i<size;i++){
            my_array[i] = my_array[i+1];
             
         }
         size--;

         return removed_element;
    }

	// remove method by element
	public Object remove(Object element){
        int index = -1;
        for(int i = 0; i<size;i++){
            if (element == (my_array[i])|| element.equals( my_array[i])){  // checking if i is equal to object element
                index = i;
                break;
            }
            }
            if(index != -1){
              remove(index);// calling the remove by index method
            }
    return  element;
}

	// get method
	public Object get(int index) throws IndexOutOfBoundsException{
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Give Index "+ index + " actual size "+ size);
        } 
        return my_array[index];
        }

	// size method
	public int size(){
        return size;
    }

	// isEmpty method
	public boolean isEmpty(){
        return my_array == null|| size() == 0;
    }

	//display method, format: [element, element, element,...., element]
	public String display(){
        // to return a string represantation of the Objects
        return Arrays.toString(my_array);

    }
    // set method
    public void set(int index, Object element){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Give Index "+ index + " actual size "+ size);
        }
        my_array[index]= element;
        
    }
    

}

public class MyArrayList{
public static void main(String[] args) {
    CustomArrayList names = new CustomArrayList ();
     



    names.add("nonzuzo");
    names.add("Vincent");
    names.add("Mcebo");
    names.add("Sylvia");



    names.remove(0);
    names.remove( "Mcebo");
    //System.out.println(names.size());
     
   //System.out.println("index at 0 " + names.get(0));
   System.out.println(names.display());
   System.out.println(names.isEmpty());
    

    
    
    //to print out added elements
    //for(int i = 0;i<names.size();i++){
        //System.out.println(names.get(i));
  // }
    
}
}