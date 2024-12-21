class MyHashMap {
  int[] arr;

  public MyHashMap() {
      this.arr = new int[1000001];
      Arrays.fill(arr, -1);
  }
  
  public void put(int key, int value) {
      this.arr[key] = value;
  }
  
  public int get(int key) {
      return this.arr[key];
  }
  
  public void remove(int key) {
      this.arr[key] = -1;
  }
}

/**
* Your MyHashMap object will be instantiated and called as such:
* MyHashMap obj = new MyHashMap();
* obj.put(key,value);
* int param_2 = obj.get(key);
* obj.remove(key);
*/