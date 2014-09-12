package sicp

/**
 * 1.2.2 Tree Recursion Example
 */
object CountChange {
	def main(args:Array[String]):Unit={
		println(count_ways_v2(1,List(0.5,0.25,0.1,0.05,0.01)))
//		println(count_ways(100,List(50,25,10,5,1)))
	}
	def count_ways(amount:Int, coins:List[Int]):Int={
		if(coins.size<=0||amount<=0){//invalid parameters
			return 0
		}
		val first=coins.head
		var total:Int=0
		if(amount==first){
			total=count_ways(amount, coins.slice(1, coins.size))+1
		}else if(amount>first) {
			total=count_ways(amount, coins.slice(1, coins.size))+count_ways(amount-first,coins)
		}else{
			total=count_ways(amount, coins.slice(1,coins.size))
		}
		println(f"[${amount}%s]["+coins+"]:"+total)
		return total
	}

	/**
	 * 由于浮点数的精度问题, count_ways_v2(1,List(0.5,0.25,0.1,0.05,0.01))的结果计算结果是错误的（3）.
	 * 在减法运算的时候,0.15-0.1结果是0.04999999999999999.
	 * 因此,无法除尽.
	 * @param amount
	 * @param coins
	 * @return
	 */
	def count_ways_v2(amount:Double, coins:List[Double]):Int={
		if(coins.size<=0||amount<=0){//invalid parameters
			return 0
		}
		val first=coins.head
		var total:Int=0
		if(amount==first){
			total=count_ways_v2(amount, coins.slice(1, coins.size))+1
		}else if(amount>first) {
			total=count_ways_v2(amount, coins.slice(1, coins.size))+count_ways_v2(amount-first,coins)
		}else{
			total=count_ways_v2(amount, coins.slice(1,coins.size))
		}
		println(f"[${amount}%s]["+coins+"]:"+total)
		return total
	}
}
