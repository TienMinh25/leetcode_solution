class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {
      String regex = "[!\\?',;\\.\\ ]+";

      String[] splitted = paragraph.split(regex);

      HashMap<String, Integer> map = new HashMap<>();
      Set<String> bannedSet = new HashSet<>();

      for (var wordBanned : banned) {
          bannedSet.add(wordBanned);
      }

      for (var word : splitted) {
          map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0) + 1);
      }

      String result = "";

      for (var key : map.keySet()) {
          if (map.getOrDefault(result, 0) < map.get(key) && !bannedSet.contains(key)) {
              result = key;
          }
      }

      return result;
  }
}