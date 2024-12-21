class MyHashSet {
  int[] arr;

  public MyHashSet() {
      this.arr = new int[1000001];
  }
  
  public void add(int key) {
      this.arr[key] = 1;
  }
  
  public void remove(int key) {
      this.arr[key] = 0;
  }
  
  public boolean contains(int key) {
      return this.arr[key] == 1;
  }
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/