/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// dung hash map de luu tru lai cac info cua employee co id tuong ung
class Solution {
  Map<Integer, Employee> mapping;

  public int getImportance(List<Employee> employees, int id) {
      mapping = new HashMap<>();

      employees.forEach(e -> mapping.put(e.id, e));

      return dfs(mapping.get(id));
  }

  private int dfs(Employee employee) {
      if (employee.subordinates.size() == 0) {
          return employee.importance;
      }

      int currTotal = 0;

      for (int i = 0; i < employee.subordinates.size(); i++) {
          var currEmployee = mapping.get(employee.subordinates.get(i));
          currTotal += dfs(currEmployee);
      }

      return currTotal + employee.importance;
  }
}