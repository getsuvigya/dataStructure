package trieByWord;

import java.util.*;

public class Trie{
    private TrieNode root;

    public static void main(String[] args) {
        ArrayList<String> arrayString = new ArrayList<>();
        arrayString.add("Aquaman");
        arrayString.add("Spider-Man: Into the Spider-Verse");
        arrayString.add("KGF");
        arrayString.add("Ralph Breaks The Internet");
        arrayString.add("The Grinch");
        arrayString.add("Bohemian Rhapsody");
        arrayString.add("Maari");
        arrayString.add("Dilwale Dulhania Le Jaayenge");

        HashMap<String , List<String>> hashMap = new HashMap<>();
        for(String s : arrayString){
            String[] arr = s.split(" ");
            hashMap.put(s ,  Arrays.asList(arr));
        }

        Trie trie = new Trie();
        for (String str : arrayString) {
            trie.addWord(str);
        }

        for(String str : trie.wordsByPrefix("dilalec")){


            System.out.println(str);
        }

    }
    public Trie() {
        this.root = new TrieNode(' ');
    }

    public void addWord(String word) {
        char[] cArray = word.toCharArray();
        TrieNode temp = root;
        TrieNode tn = null;
        int index = 0;

        do {
            tn = temp.children[cArray[index] - 'a'];
            if (tn != null) {
                temp = tn;
                index++;
                // if the word got over, then it is already in the trie.
                if (index >= word.length()) {
                    temp.terminal = true;
                    temp.word = word;
                    return;
                }
            }
        } while (tn != null);

        // temp is the last node and the word to add is lengthier
        for (; index < cArray.length; index++) {
            temp.children[cArray[index] - 'a'] = new TrieNode(cArray[index]);
            temp = temp.children[cArray[index] - 'a'];
        }

        temp.terminal = true;
        temp.word = word;
    }

    public String[] wordsByPrefix(String prefix) {
        char[] cArray = prefix.toCharArray();
        TrieNode temp = root;
        TrieNode tn = null;
        int index = 0;

        do {
            tn = temp.children[cArray[index] - 'a'];
            // if you reached the end of the string, then no words with this prefix
            if (tn == null) {
                return null;
            }

            index++;
            temp = tn;
        } while (index < cArray.length);

        // temp is at the node representing the last char of the prefix
        // do a traversal for all paths below this.
        List<String> words = new ArrayList<String>();
        Deque<TrieNode> DQ = new ArrayDeque<TrieNode>();
        DQ.addLast(temp);
        while (!DQ.isEmpty()) {
            TrieNode first = DQ.removeFirst();
            if(first.terminal){
                words.add(first.word);
            }

            for(TrieNode n : first.children){
                if(n != null){
                    DQ.add(n);
                }
            }
        }

        return words.toArray(new String[0]);
    }
}

 class TrieNode {
    TrieNode[] children;
    char label;
    boolean terminal;
    String word;

    private static int ALPHABET_SIZE = 26;

    public TrieNode() {
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    public TrieNode(char l) {
        this();
        this.label = l;
    }
}