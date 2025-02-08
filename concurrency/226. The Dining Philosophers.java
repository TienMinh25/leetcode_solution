class DiningPhilosophers {
  private Semaphore pick;
  private Semaphore[] forks;

  public DiningPhilosophers() {
      this.pick = new Semaphore(1);
      this.forks = new Semaphore[5];
      for (int i = 0; i < 5; i++)
          forks[i] = new Semaphore(1);
  }

  // call the run() method of any runnable to execute its code
  public void wantsToEat(int philosopher,
                         Runnable pickLeftFork,
                         Runnable pickRightFork,
                         Runnable eat,
                         Runnable putLeftFork,
                         Runnable putRightFork) throws InterruptedException {
      var left = forks[philosopher];
      var right = forks[(philosopher + 4) % 5];

      pick.acquire();
      left.acquire();
      pickLeftFork.run();

      right.acquire();
      pickRightFork.run();

      eat.run();

      left.release();
      putLeftFork.run();

      right.release();
      putRightFork.run();

      pick.release();
  }
}