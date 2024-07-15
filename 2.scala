import scala.io.StdIn.readLine

case class Book(title:String,author:String,isbn:String)

object LibraryManagementSystem{
    var library: Set[Book]=Set(
        Book("The Catcher in the Rye","J.D. Salinger","438794873982"),
        Book("To Kill a Mockingbird","Harper Lee","093409483242"),
        Book("1984","George Orewell","8234982922")
    )

    def main(args:Array[String]):Unit={
        var continue=true
        while(continue){
            println("""Choose an option:
                1. Display Library
                2. Add Book
                3. Remove Book
                4. Check Book by ISBN
                5. Search Book by Title
                6. Display Books by Author
                7. Exit""".stripMargin)
            val choice=readLine().toInt
            choice match{
                case 1 => displayLibrary()
                case 2 => addBook()
                case 3 => removeBook()
                case 4 => checkBookByISBN()
                case 5 => searchBookByTitle()
                case 6 => displayBookByAuthor()
                case 7 => continue=false
                case _ => println("Invalid option. Please try again.")
            }
        }
    }

    def displayLibrary(): Unit={
        if(library.isEmpty){
            println("The library is empty.")
        } else {
            library.foreach(book => println("Title: "+book.title+" Author: "+book.author+" ISBN: "+book.isbn))
        }
    }

    def addBook(): Unit={
        println("Enter the title of the book:")
        val title=readLine()
        println("Enter the author of the book:")
        val author=readLine()
        println("Enter the isbn of the book:")
        val isbn=readLine()

        val newBook=Book(title,author,isbn)
        if(library.exists(_.isbn==isbn)){
            println("A book with this ISBN already exists in the library.")
        } else {
            library+=newBook
            println("Book "+title+" added to the library.")
        }
    }

    def removeBook(): Unit={
        println("Enter the ISBN of the book to remove: ")
        val isbn=readLine()
        if(library.exists(_.isbn == isbn)){
            library=library.filterNot(_.isbn==isbn)
            println("Book with ISBN "+isbn+" removed from the library")
        } else {
            println("No book with this ISBN found in the library")
        }
    }

    def checkBookByISBN():Unit={
        println("Enter the ISBN of the book to check: ")
        val isbn=readLine()
        if(library.exists(_.isbn == isbn)){
            library=library.filterNot(_.isbn==isbn)
            println("Book with ISBN "+isbn+" exists in the library")
        } else {
            println("No book with this ISBN found in the library")
        }
    }

    def searchBookByTitle(): Unit={
        println("Enter the title of the book to search: ")
        val title = readLine()
        val foundBooks=library.filter(_.title.equalsIgnoreCase(title))
        if(foundBooks.nonEmpty){
            foundBooks.foreach(book=>println("Title: "+book.title+" Author: "+book.author+" ISBN: "+book.isbn))
        } else {
            println("No book with this title found in the library")
        }
    }

    def displayBookByAuthor(): Unit={
        println("Enter the author to search: ")
        val author = readLine()
        val foundBooks=library.filter(_.author.equalsIgnoreCase(author))
        if(foundBooks.nonEmpty){
            foundBooks.foreach(book=>println("Title: "+book.title+" Author: "+book.author+" ISBN: "+book.isbn))
        } else {
            println("No book with by this author found in the library")
        }
    }
}