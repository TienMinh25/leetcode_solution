class Foo {
  private Lock mutualLock;
  private Condition firstCV, secondCV;
  private boolean checkFirst, checkSecond;

  public Foo() {
      this.mutualLock = new ReentrantLock();
      firstCV = mutualLock.newCondition();
      secondCV = mutualLock.newCondition();
      checkFirst = false;
      checkSecond = false;
  }

  public void first(Runnable printFirst) throws InterruptedException {
      mutualLock.lock();
      try {
          printFirst.run();
          checkFirst = true;
          firstCV.signal();
      } finally {
          mutualLock.unlock();
      }
      // printFirst.run() outputs "first". Do not change or remove this line.
  }

  public void second(Runnable printSecond) throws InterruptedException {
      mutualLock.lock();
      try {
          while (!checkFirst)
              firstCV.await();
          printSecond.run();
          checkSecond = true;
          secondCV.signal();
      } finally {
          mutualLock.unlock();
      }
      // printSecond.run() outputs "second". Do not change or remove this line.
  }

  public void third(Runnable printThird) throws InterruptedException {
      mutualLock.lock();
      try {
          while (!checkSecond)
              secondCV.await();
          printThird.run();
      } finally {
          mutualLock.unlock();
      }
      // printThird.run() outputs "third". Do not change or remove this line.
  }
}