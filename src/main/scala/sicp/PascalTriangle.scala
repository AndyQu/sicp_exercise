package sicp

/**
 * Exercise 1.12
 */
object PascalTriangle {
	def main(args:Array[String]):Unit={
		println(number_at(5,3))
		println(number_at(4,2))
		println(number_at(10,5))
	}
	def number_at(row:Int, index:Int):Int={
		if(index>row || row<=0 || index<=0){
			//invalid parameter
			return 0
		}
		if(index==1 || index==row){
			return 1
		}
		if(row==1){
			return 1
		}
		return number_at(row-1,index-1)+number_at(row-1,index)
	}
}
