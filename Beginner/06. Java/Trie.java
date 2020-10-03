package Trie;

import java.util.HashMap;

public class Trie {

  private class Node {
    char ch;
    boolean eow;
    HashMap<Character, Node> table = new HashMap<>();

    public Node(char ch)
    {
      this.ch = ch;
    }
  }

  private Node root;

  public Trie()
  {
    root = new Node('*');
  }

  public void addWord(String word)
  {
    addWord(root, word);
  }

  private void addWord(Node node, String word)
  {
    if (word.length() == 0)
    {
      node.eow = true;
      return;
    }

    char ch = word.charAt(0);
    word = word.substring(1);

    if (!node.table.containsKey(ch))
    {
      Node nn = new Node(ch);
      node.table.put(ch, nn);
    }

    addWord(node.table.get(ch), word);
  }


  public boolean searchWord(String word)
  {
    return searchWord(root, word);
  }

  private boolean searchWord(Node node, String word)
  {

    if (word.length() == 0)
    {
      return node.eow;
    }

    char ch = word.charAt(0);
    word = word.substring(1);

    if (!node.table.containsKey(ch))
    {
      return false;
    }

    return searchWord(node.table.get(ch), word);
  }


  public void display()
  {
    display(root, "");
  }

  private void display(Node node, String str)
  {
    if (node.eow)
    {
      System.out.println(str);
    }


    for (char ch : node.table.keySet())
    {
      display(node.table.get(ch), str + ch);
    }
  }

  public void removeWord(String str)
  {
    removeWord(root , str);
  }

  private void removeWord(Node node , String word)
  {
    if (word.length() == 0)
    {
      node.eow = false;
      return;
    }

    char ch = word.charAt(0);
    word = word.substring(1);

    if (node.table.containsKey(ch))
    {
      Node child = node.table.get(ch);
      removeWord(node.table.get(ch), word);

      if (!child.eow && child.table.size() == 0)
      {
        node.table.remove(ch);
      }
    }

  }

}
