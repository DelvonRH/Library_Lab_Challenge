import java.util.ArrayList;
public class Library 
{
	private String address;
	ArrayList<Book> books = new ArrayList<Book>();
	
    // Add the missing implementation to this class
	public Library(String address)
	{
		this.address = address;
	}
	
	public static String printOpeningHours()
	{
		return "Libraries are open daily from 9am to 5pm.";
	}
	
	public String printAddress()
	{
		return address;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public void addBook(Book book)
	{
		books.add(book);
	}
	
	public void borrowBook(String bookName)
	{
		boolean doesNotExist = false;
		
		for(int i = 0; i < books.size(); i++)
		{
			if(bookName.equals(books.get(i).getTitle()))
			{
				if(books.get(i).isBorrowed())
				{
					System.out.println("Sorry, this book is already borrowed.");
					books.remove(books.get(i));
				}
				else
				{
					System.out.println("You successfully borrowed " + bookName);
					books.get(i).rented();
				}	
			}
			else
			{
				doesNotExist = true;
			}
		}
		
		if(!doesNotExist)
		{
			System.out.println("Sorry, this book is not in our catalog.");
		}
	}
	
	public void returnBook(String bookName)
	{
		boolean exists = false;
		
		for(int i = 0; i < books.size(); i++)
		{
			if(books.get(i).getTitle().equals(bookName))
			{
				exists = true;
				books.get(i).returned();
			}
			else
			{
				exists = false;
			}	
		}
		if(!exists)
		{
			books.add(new Book(bookName));
			System.out.println("You successfully returned " + bookName);
		}
		
		
	}
	
	public void printAvailableBooks() 
	{
		if(books.size() == 0)
		{
			System.out.println("No book in catalog");
		}
		
		for(int i = 0; i < books.size(); i++)
		{
			{
				System.out.println(books.get(i).getTitle());
			}
		}
	}
	
	
	
	@Override
	public String toString() 
	{
		return "Library [books=" + books + "]";
	}

	
	
	public static void main(String[] args) 
    {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
       
        
        System.out.println(firstLibrary.toString());

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        System.out.print(printOpeningHours());
        System.out.println();

        System.out.println("Library addresses:");
        System.out.println(firstLibrary.printAddress());
        System.out.print(secondLibrary.printAddress());
        System.out.println();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

	
}