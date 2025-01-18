/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    // private List<Integer> flattenList;
    // private int currIdx;
    private Queue<Integer> queue;
    // private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        // cong cu thi minh co isInteger -> check la list hay integer
        // neu la integer -> getInteger
        // neu khong thi getList()
        // y tuong la coi nhu moi 1 phan tu ben trong do la 1 row (trong row co the
        // recursive
        // nhieu row khac)
        // coi no la tree, dung queue de duyet level by level, khac la duyet theo dang
        // neu la integer thi cho vao list, khong thi add cac phan tu moi vao sau queue
        // la dc (su dung queue hoac stack)
        // stack thi de lam hon, perf tot hon

        // flattenList = new ArrayList<>();
        // currIdx = 0;
        // queue solution
        queue = new LinkedList<>();

        // nestedList.forEach(nested -> {
        //     queue.offer(nested);

        //     while (!queue.isEmpty()) {
        //         var temp = queue.poll();

        //         if (temp.isInteger() == true) {
        //             flattenList.add(temp.getInteger());
        //         } else {
        //             List<NestedInteger> listQueue = new ArrayList<>();
        //             while (!queue.isEmpty()) {
        //                 listQueue.add(queue.poll());
        //             }
        //             temp.getList().forEach(a -> queue.offer(a));
        //             listQueue.forEach(a -> queue.offer(a));
        //         }
        //     }
        // });

        // stack solution
        // stack = new Stack<>();

        // for (int i = nestedList.size() - 1; i >= 0; i--)
        //     stack.push(nestedList.get(i));

        // while (!stack.empty()) {
        //     var temp = stack.pop();

        //     if (temp.isInteger()) {
        //         flattenList.add(temp.getInteger());
        //     } else {
        //         var tempList = temp.getList();
        //         for (int i = tempList.size() - 1; i >= 0; i--)
        //             stack.push(tempList.get(i));
        //     }
        // }

        // recursive solution
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (var x : nestedList) {
            if (x.isInteger()) {
                queue.offer(x.getInteger());
            } else {
                dfs(x.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */