package it.unibo.res
class Counter(start: Int) {
	var seq = start
		private set
	
	var lastHit=true

	fun update() {
		seq++
	}
}