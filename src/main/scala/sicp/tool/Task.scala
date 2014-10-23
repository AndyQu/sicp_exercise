package sicp.tool

object Task {
	def run_task(task:()=>Unit)= {
		val start = System.currentTimeMillis()
		task.apply()
		val end = System.currentTimeMillis()
		println("[time consumed]:" + (end - start) + " ms")
	}
}
