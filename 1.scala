import scala.io.StdIn.readLine

object InventoryManagementSystem{
    def main(args:Array[String]):Unit={
        val productList=getProductList()
        printProductList(productList)
        val totalProducts=getTotalProducts(productList)
        println("Total number of products: "+totalProducts)
    }

    def getProductList(): List[String]={
        var products: List[String]=List()
        var input: String=""
        println("Enter product names (type done when finished): ")
        input=readLine()
        while(input.toLowerCase!="done"){
            if(input.nonEmpty){
                products=products :+ input
            }
            input=readLine()
        }
        products
    }

    def printProductList(products: List[String]):Unit={
        products.zipWithIndex.foreach{case(product,index)=>
            println((index+1)+" "+product)}
    }

    def getTotalProducts(products:List[String]):Int={
        products.length
    }
}
