class Solution {
  public int uniqueMorseRepresentations(String[] words) {
      Set<String> outputTransform = new HashSet<>();

      var encodingLetters = new ArrayList<String>(
              List.of(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                      "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."));

      for (String word : words) {
          char[] process = word.toCharArray();
          StringBuilder sb = new StringBuilder();

          for (var x : process) {
              sb.append(encodingLetters.get(x - 'a'));
          }

          outputTransform.add(sb.toString());
      }
      
      return outputTransform.size();
  }
}