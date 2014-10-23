package sicp

/**
 * F(0)=0, F(1)=1
 */
object Fibonacci {
	def main(args:Array[String]):Unit={
		tool.Task.run_task(()=>println(normal(40)))
		tool.Task.run_task(()=>println(fast(40)))
	}
	def normal(n:Long):Long={
		if(n<=0){
			return 0
		}else if(n==1){
			return 1
		}else{
			var a=0
			var b=1
			var count=1
			while(count<n){
				val c=a+b
				a=b
				b=c
				count+=1
			}
			return b
		}
	}
	def fast(n:Long):Long={
		val (p, q)=compute_pq(0,1,n-1)
		val b=0
		val a=1
		return b*q+a*(p+q)
	}

	private def compute_pq(p:Long,q:Long,n:Long):(Long,Long)={
		if(n==1){
			return (p,q)
		}else if(n%2==0){
			val (newp,newq)=square(p,q)
			return compute_pq(newp,newq,n/2)
		}else{
			val (newp,newq)=square(p,q)
			val (nnp,nnq)=compute_pq(newp,newq,(n-1)/2)
        	return join(nnp,nnq, p,q)
		}
	}
	def square(p:Long,q:Long):(Long,Long)={
		return (p*p+q*q, 2*p*q+q*q)
	}
	def join(p0:Long,q0:Long,p1:Long,q1:Long):(Long,Long)={
		return (p0*p1+q0*q1, p0*q1+q0*p1+q0*q1)
	}
}
