object Fibonacci{
    def main(args:Array[String]):Unit={
        println("Enter the number of fibonacci numbers to print: ")
        val n=scala.io.StdIn.readInt()
        println("The first "+n+" Fibonacci numbers are: ")
        printFibonacci(n)
    }

    def printFibonacci(n:Int): Unit={
        for(i<-0 until n){
            println(fibonacci(i))
        }
    }

    def fibonacci(n:Int):Int=n match{
        case 0 => 0
        case 1 => 1
        case _ => fibonacci(n-1)+fibonacci(n-2)
    }
}