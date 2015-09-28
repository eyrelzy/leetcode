package trie;

public class AddAndSearchWordDS {
  class TrieNode{
     TrieNode[] children = new TrieNode[26];
     boolean isLeaf;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    AddAndSearchWordDS aas = new AddAndSearchWordDS();
    aas.addWord("abc");
    aas.addWord("adc");
    System.out.println(aas.search("d.."));
  }
  TrieNode root = new TrieNode();
  // Adds a word into the data structure.
  public void addWord(String word) {
      TrieNode curr = root;
      for(char c : word.toCharArray()){
          int index = c - 'a';
          if(curr.children[index] == null){
              curr.children[index] = new TrieNode();
          }
          curr = curr.children[index];
      }
      curr.isLeaf = true;
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
      TrieNode curr = root;
      return searchWithRoot(word, curr);
  }
  // AC
  private boolean match(char[] chs, int k, TrieNode node) {
    if (k == chs.length) return node.isLeaf;   
    if (chs[k] != '.') {
        int index = chs[k] - 'a';
        return node.children[index] != null && match(chs, k + 1, node.children[index]);
    } else {
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                if (match(chs, k + 1, node.children[i])) {
                    return true;
                }
            }
        }
    }
    return false;
}
  //Why could this be LTE 
  private boolean searchWithRoot(String word, TrieNode root){
      TrieNode curr = root;
      int cnt = 0;
      for(char c : word.toCharArray()){
          if(c == '.'){
              for(int i=0;i<26;i++){
                  if(curr.children[i] == null)
                      continue;
                  if(searchWithRoot(word.substring(cnt+1), curr.children[i])){
                      return true;
                  }
              }
          }else{
              int index = c - 'a';
              return curr.children[index] != null && searchWithRoot(word.substring(cnt+1), curr.children[index]);
          }
      }
      return curr.isLeaf;
  }

}
