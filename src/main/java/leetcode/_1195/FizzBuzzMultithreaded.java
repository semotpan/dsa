package leetcode._1195;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

public class FizzBuzzMultithreaded {

    static class AtomicFizzBuzz {

        private final AtomicInteger counter;
        private final int n;

        AtomicFizzBuzz(int n) {
            this.n = n;
            counter = new AtomicInteger(1);
        }

        void fizz(Runnable printFizz) throws InterruptedException {
            int count;
            while ((count = counter.get()) <= n) {
                if (count % 3 == 0 && count % 5 != 0) {
                    printFizz.run();
                    counter.incrementAndGet();
                }
            }
        }

        void buzz(Runnable printBuzz) throws InterruptedException {
            int count;
            while ((count = counter.get()) <= n) {
                if (count % 3 != 0 && count % 5 == 0) {
                    printBuzz.run();
                    counter.incrementAndGet();
                }
            }
        }

        void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            int count;
            while ((count = counter.get()) <= n) {
                if (count % 3 == 0 && count % 5 == 0) {
                    printFizzBuzz.run();
                    counter.incrementAndGet();
                }
            }
        }

        void number(IntConsumer printNumber) throws InterruptedException {
            int count;
            while ((count = counter.get()) <= n) {
                if (count % 3 != 0 && count % 5 != 0) {
                    printNumber.accept(count);
                    counter.incrementAndGet();
                }
            }
        }
    }

    static class SynchronizedFizzBuzz {
        private final int n;
        private int counter;


        public SynchronizedFizzBuzz(int n) {
            this.n = n;
            this.counter = 1;
        }

        public synchronized void fizz(Runnable printFizz) throws InterruptedException {
            while (counter <= n) {
                if (counter % 3 == 0 && counter % 5 != 0) {
                    printFizz.run();
                    ++counter;
                    super.notifyAll();
                } else
                    super.wait();
            }

        }

        public synchronized void buzz(Runnable printBuzz) throws InterruptedException {

            while (counter <= n) {
                if (counter % 3 != 0 && counter % 5 == 0) {
                    printBuzz.run();
                    ++counter;
                    super.notifyAll();
                } else
                    super.wait();
            }

        }

        public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

            while (counter <= n) {
                if (counter % 3 == 0 && counter % 5 == 0) {
                    printFizzBuzz.run();
                    ++counter;
                    super.notifyAll();
                } else
                    super.wait();
            }
        }

        public synchronized void number(IntConsumer printNumber) throws InterruptedException {
            while (counter <= n) {
                if (counter % 3 != 0 && counter % 5 != 0) {
                    printNumber.accept(counter);
                    ++counter;
                    super.notifyAll();
                } else
                    super.wait();
            }

        }
    }

    static class SynchronizedMutexFizzBuzz {

        private final int n;
        private final Object mutex;
        private int counter;

        public SynchronizedMutexFizzBuzz(int n) {
            this.n = n;
            this.mutex = new Object();
            this.counter = 1;
        }

        public void fizz(Runnable printFizz) throws InterruptedException {
            eval((c) -> c % 3 == 0 && c % 5 != 0, printFizz);
        }

        public void buzz(Runnable printBuzz) throws InterruptedException {
            eval((c) -> c % 3 != 0 && c % 5 == 0, printBuzz);
        }

        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            eval((c) -> c % 3 == 0 && c % 5 == 0, printFizzBuzz);
        }

        public void number(IntConsumer printNumber) throws InterruptedException {
            eval((c) -> c % 3 != 0 && c % 5 != 0, () -> printNumber.accept(counter));
        }

        private void eval(Predicate<Integer> predicate, Runnable callback) throws InterruptedException {
            synchronized (mutex) {
                while (counter <= n) {
                    if (predicate.test(counter)) {
                        callback.run();
                        ++counter;
                        mutex.notifyAll();
                    } else
                        mutex.wait();
                }
            }
        }
    }

    static class LockFizzBuzz {

        private final int n;
        private final Lock mutex;
        private int counter;

        public LockFizzBuzz(int n) {
            this.n = n;
            this.mutex = new ReentrantLock(true);
            this.counter = 1;
        }

        public void fizz(Runnable printFizz) throws InterruptedException {
            eval((c) -> c % 3 == 0 && c % 5 != 0, printFizz);
        }

        public void buzz(Runnable printBuzz) throws InterruptedException {
            eval((c) -> c % 3 != 0 && c % 5 == 0, printBuzz);
        }

        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            eval((c) -> c % 3 == 0 && c % 5 == 0, printFizzBuzz);
        }

        public void number(IntConsumer printNumber) throws InterruptedException {
            eval((c) -> c % 3 != 0 && c % 5 != 0, () -> printNumber.accept(counter));
        }

        private void eval(Predicate<Integer> predicate, Runnable callback) throws InterruptedException {
            while (counter <= n) {
                mutex.lock();

                if (counter > n) {
                    mutex.unlock();
                    return;
                }

                if (predicate.test(counter)) {
                    callback.run();
                    ++counter;
                }

                mutex.unlock();
            }
        }
    }
}

class FizzBuzz {

    private final int n;
    private final Lock mutex;
    private int counter;

    public FizzBuzz(int n) {
        this.n = n;
        this.mutex = new ReentrantLock();
        this.counter = 1;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        eval((c) -> c % 3 == 0 && c % 5 != 0, printFizz);
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        eval((c) -> c % 3 != 0 && c % 5 == 0, printBuzz);
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        eval((c) -> c % 3 == 0 && c % 5 == 0, printFizzBuzz);
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        eval((c) -> c % 3 != 0 && c % 5 != 0, () -> printNumber.accept(counter));
    }

    private void eval(Predicate<Integer> predicate, Runnable callback) throws InterruptedException {
        while (counter <= n) {
            mutex.lock();

            if (counter > n) {
                mutex.unlock();
                return;
            }

            if (predicate.test(counter)) {
                callback.run();
                ++counter;
            }

            mutex.unlock();
        }
    }
}
