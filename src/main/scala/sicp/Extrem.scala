package sicp

/**
 * f(n)=base^n
 * g(n)=base*(g(n-1)+1)
 *
 * I want to see what f(n)/g(n) is as n is increasing.
 *
 * */
object Extrem {
	def main(args:Array[String]):Unit={
		val base=3
		var f=base
		var g=base
		var i=0
		while(i<=50){
			println(f+","+g+":"+f*1.0/g)
			f*=base
			g=base*(g+1)
			i=i+1
		}
	}
	def f(N:Int):Int={
		if(N<=1){
			return 3
		}else{
			return (f(N-1)+1)*3
		}
	}
}
