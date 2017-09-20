package main.philosophers

internal class Philosopher(
        private val name: String,
        private val leftFork: Fork,
        private val rightFork: Fork) : Runnable {
    override fun run() {
        while (true) {
            eat()
            Thread.sleep(1)
        }
    }

    private fun eat() {
        synchronized(leftFork) {
            System.out.println("$name has $leftFork as leftFork")
            synchronized(rightFork) {
                System.out.println("$name has $rightFork as rightFork")
                System.out.println("$name eats with forks left=$leftFork and right=$rightFork")
                System.out.println("$name releases $rightFork that was rightFork")
            }
            System.out.println("$name releases $leftFork that was leftFork")
        }
    }
}