class KthLargest {
    MinHeap heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new MinHeap(k);
        this.k = k;
        for (int num : nums) {
            heap.insert(num);
        }
    }

    public int add(int val) {
        heap.insert(val);
        return heap.peek();
    }

    private class MinHeap {
        int size;
        int[] heap;
        int capacity;

        public MinHeap(int capacity) {
            heap = new int[capacity];
            this.capacity = capacity;
            this.size = 0;
        }

        public void insert(int val) {
            if (size < capacity) {
                heap[size] = val;
                size++;
                heapifyUp();
            } else if (val > heap[0]) {
                heap[0] = val;
                heapifyDown();
            }
        }

        private void heapifyUp() {
            int index = size - 1;
            while (index > 0 && heap[index] < heap[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
            }
        }

        private void heapifyDown() {
            int index = 0;
            while (leftChild(index) < size) {
                int smallerChild = leftChild(index);
                if (rightChild(index) < size && heap[rightChild(index)] < heap[smallerChild])
                    smallerChild = rightChild(index);
                if (heap[index] <= heap[smallerChild])
                    break;
                swap(index, smallerChild);
                index = smallerChild;
            }
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int leftChild(int i) {
            return (2 * i + 1);
        }

        private int rightChild(int i) {
            return (2 * i + 2);
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public int peek() {
            return heap[0];
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */