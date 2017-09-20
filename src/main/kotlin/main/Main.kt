package main

import main.philosophers.Fork
import main.philosophers.Philosopher

fun main(args: Array<String>) {
    val amountOfPhilosophers = 2
    val forks = Array(amountOfPhilosophers) { Fork(it) }
    val philosophers = Array(amountOfPhilosophers) {
        if (it == amountOfPhilosophers - 1) {
            Philosopher("Philosopher $it", forks[(it + 1) % forks.size], forks[it])
        } else {
            Philosopher("Philosopher $it", forks[it], forks[(it + 1) % forks.size])
        }
    }
    for (i in 0 until amountOfPhilosophers) {
        Thread(philosophers[i], "Philosopher $i thread").start()
    }
}
