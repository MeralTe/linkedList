package verketteteliste;

public class Test {

	public static void main(String[] args) {
		//create list
		StringLinkedList onepiece = new StringLinkedList(); 
     System.out.println(onepiece.isEmpty()); //true but list is not empty?!
		onepiece.add("Ruffy"); //add values in the list (size 5)
		onepiece.add("Zorro");
		onepiece.add("Lysopp");
		onepiece.add("Chopper");
		onepiece.add("Nami");
		onepiece.add("Nico Robin");

// add new element in list
    //  onepiece.add(0,"Sanji"); //adds at the start   
    //  onepiece.add(6, "Sanji"); //adds in the end
    //  onepiece.add(1,"Sanji"); // adds in the specified index
    //  onepiece.add(8,"Sanji"); //IndexOutOfBoundsException ( index > size())

//is specified element in list
//      System.out.println(onepiece.contains("Nami")); //if value is in list TRUE
//      System.out.println(onepiece.contains("Namiii")); //false

//the index of specified value
//	    System.out.println(onepiece.indexOf("Nami")); //value is in index _ ?

//delete from list
//	    System.out.println(onepiece.remove("Nami")); //delete Nami from list

//	    System.out.println(onepiece.remove(3)); //return value than the value
//	    System.out.println(onepiece.remove(7)); //IndexOutOfBoundsException ( index > size())

//	    System.out.println(onepiece.get(3)); //show value of 3. index (its Chopper)

		for (int i = 0; i< onepiece.size(); i++) { //show complete list
			System.out.println(onepiece.get(i));
		}
	}
}


