package trie;

class TrieNode{
  private final int R = 26;//there will be no more than 26 childs
  private final TrieNode[] children = new TrieNode[R];
  private String item = "";
  public TrieNode[] getChildren() {
    return children;
  }
  public TrieNode getChild(int i){
    return children[i];
  }
  public void setChild(int i, TrieNode node){
    children[i] = node;
  }
  public String getItem() {
    return item;
  }
  public void setItem(String item) {
    this.item = item;
  }
}

public class Trie {
  
  public static void main(String[] args){
    insert("abc");
    System.out.println(search("abc"));
    System.out.println(search("ab"));
    insert("ab");
    System.out.println(search("ab"));
    insert("ab");
    System.out.println(search("ab"));
  }
  
  private static TrieNode root = new TrieNode();
  public Trie(){
    root = new TrieNode();
  }
  public static void insert(String word){
    TrieNode curr = root;
    for(char c : word.toCharArray()){
      int index = c -'a';
      if(curr.getChild(index) == null){
        curr.setChild(index, new TrieNode());
      }
      curr = curr.getChild(index);
    }
    curr.setItem(word);
  }
  public static boolean search(String word){
    TrieNode curr = root;
    for(char c: word.toCharArray()){
      int index = c - 'a';
      if(curr.getChild(index) == null){
        return false;
      }
      curr = curr.getChild(index);
    }
    return curr.getItem().equals(word);
  }
  public static boolean startsWith(String prefix){
    TrieNode curr = root;
    for(char c : prefix.toCharArray()){
      int index = c - 'a';
      if(curr.getChild(index) == null){
        return false;
      }
      curr = curr.getChild(index);
    }
    return true;
  }

}
