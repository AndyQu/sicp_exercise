package sicp
import scala.util.control.Breaks._
/**
 * Exercise 1.16 1.17 1.18
 */
object Exponentiation {
	def mul(a:Long,b:Long):Long={
		return a*b
	}
	def add(a:Long,b:Long):Long={
		return a+b
	}
	def main(args:Array[String]):Unit={
		var base:Int=2
//		println(exp(base,1,base,16,mul))
//		println(exp(base,1,base,16,add))

		println(exp_iterative(base, 10))
	}
	def exp(result:Long,m:Int,base:Long,n:Int,  operator:(Long,Long)=>Long):Long={
		if(m>n){
			throw new Exception("m can't be bigger than n")
		}
		if(m==n){
			return result
		}
		if(m*2==n){
			return operator(result,result)
		}else if(m*2<n){
			return exp(operator(result,result),m*2, base,n, operator)
		}else{
			return operator(result, exp(base,1,base,n-m, operator))
		}
	}

	def exp_iterative(base:Long,n:Int):Long={
		var result:Long=1

		var iter_result:Long=base
		var m:Int=1
		var N:Int=n
		breakable {
			while (true) {
				if (m * 2 == N) {
					result *= (iter_result * iter_result)
					break
				} else if (m * 2 > N) {
					result = result * iter_result
					iter_result = base
					N = N - m
					m = 1
				} else if (m * 2 < N) {
					iter_result = iter_result * iter_result
					m = m * 2
				}
			}
		}
		return result
	}
}
