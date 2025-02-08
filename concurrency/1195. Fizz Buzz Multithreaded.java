class FizzBuzz {
  private int n;
  private Semaphore fizzSe, buzzSe, fizzBuzzSe, numberSe;
  private volatile int counter;

  public FizzBuzz(int n) {
      this.n = n;
      this.fizzSe = new Semaphore(0);
      this.buzzSe = new Semaphore(0);
      this.fizzBuzzSe = new Semaphore(0);
      this.numberSe = new Semaphore(1);
      this.counter = 1;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
      while (true) {
          fizzSe.acquire();
          if (counter > n) {
              fizzBuzzSe.release();
              buzzSe.release(); 
              numberSe.release();
              break;
          }
          printFizz.run();
          counter++;

          if (counter % 3 != 0 && counter % 5 != 0) {
              numberSe.release(); 
          } else if (counter % 3 == 0 && counter % 5 == 0) {
              fizzBuzzSe.release();
          } else if (counter % 3 == 0 && counter % 5 != 0) {
              fizzSe.release(); 
          } else {
              buzzSe.release();
          }
      }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
      while (true) {
          buzzSe.acquire();
          if (counter > n) {
              fizzBuzzSe.release();
              fizzSe.release(); 
              numberSe.release();
              break;
          }
          printBuzz.run();
          counter++;

          if (counter % 3 != 0 && counter % 5 != 0) {
              numberSe.release(); 
          } else if (counter % 3 == 0 && counter % 5 == 0) {
              fizzBuzzSe.release();
          } else if (counter % 3 == 0 && counter % 5 != 0) {
              fizzSe.release(); 
          } else {
              buzzSe.release();
          }
      }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
      while (true) {
          fizzBuzzSe.acquire();
          if (counter > n) {
              numberSe.release();
              fizzSe.release(); 
              buzzSe.release();
              break;
          }
          printFizzBuzz.run();
          counter++;

          if (counter % 3 != 0 && counter % 5 != 0) {
              numberSe.release(); 
          } else if (counter % 3 == 0 && counter % 5 == 0) {
              fizzBuzzSe.release();
          } else if (counter % 3 == 0 && counter % 5 != 0) {
              fizzSe.release(); 
          } else {
              buzzSe.release();
          }
      }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
      while (true) {
          numberSe.acquire();
          if (counter > n) {
              fizzBuzzSe.release();
              fizzSe.release(); 
              buzzSe.release();
              break;
          }
          printNumber.accept(counter++);

          if (counter % 3 != 0 && counter % 5 != 0) {
              numberSe.release(); 
          } else if (counter % 3 == 0 && counter % 5 == 0) {
              fizzBuzzSe.release();
          } else if (counter % 3 == 0 && counter % 5 != 0) {
              fizzSe.release(); 
          } else {
              buzzSe.release();
          }
      }
  }
}