/*
Given a encoded string, your task is to print the decoded String.


https://practice.geeksforgeeks.org/problems/huffman-decoding-1/1
*/

//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;
class minHeapNode {
    char data;
    int freq;
    minHeapNode left, right;
    minHeapNode(char data, int freq){
        left = right = null;
        this.data = data;
        this.freq = freq;
    }
}
class heapComparator implements Comparator<minHeapNode> {
    public int compare(minHeapNode h1, minHeapNode h2) { 
        if (h1.freq < h2.freq) {
            return 1;
        } else if (h1.freq > h2.freq) {
            return -1;
        }
        return 0; 
    } 
} 
class driverClass {
    
    static PriorityQueue<minHeapNode> heapq;
    static HashMap<Character, Integer> freqMap;
    static HashMap<Character, String> codes;
    
    static void storeCodes(minHeapNode root, String str) {
        if(root==null)return;
        if(root.data != '$')codes.put(root.data, str);
        storeCodes(root.left, str + "0");
        storeCodes(root.right, str + "1");
    }
    
    static void encodeString(){
        minHeapNode left, right, top;
        for (Map.Entry<Character, Integer> val:freqMap.entrySet()) {
            heapq.add(new minHeapNode(val.getKey(), val.getValue()));
        }
        while (heapq.size() != 1) {
            left = heapq.poll();
            right = heapq.poll();
            top = new minHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            heapq.add(top);
        }
        storeCodes(heapq.peek(), "");
    }
    
    static void calcFreq(String str) {
        for (int i=0; i<str.length(); i++) { 
            Integer j = freqMap.get(str.charAt(i)); 
            freqMap.put(str.charAt(i), (j == null) ? 1 : j + 1); 
        } 
    }
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String str = br.readLine().trim();
            heapq = new PriorityQueue<minHeapNode>(new heapComparator());
            codes = new HashMap<Character, String>();
            freqMap = new HashMap<Character, Integer>();
            String encodedString = "";
            calcFreq(str);
            encodeString();
            for(int i=0; i<str.length(); i++){
                encodedString+=codes.get(str.charAt(i));
            }
            GfG g = new GfG();
            System.out.println(g.decodeString(heapq.peek(), encodedString));
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class GfG {
    // your required to complete this function
    // this function should return the encoded string
    // see the main function for the minHeapNode reference
    static String output = "";
    String decodeString(minHeapNode root, String encodedStr){
        // Code here
        output = "";
        recur(root, root, encodedStr, 0);
        return output;
        
    }

    // void recur(MinHeapNode root, MinHeapNode cur, String binaryString, int index, String output){
    static void recur(minHeapNode root, minHeapNode cur, String binaryString, int index){
        // MinHeapNode cur = root;
        // String output = "";
        // System.out.println("cur.data = " + cur.data + " cur.freq = " + cur.freq);
        // System.out.println("index = " + index + " binaryString.length() = " + binaryString.length());

        // if(index == binaryString.length()-1){
        //     output = output + cur.data;
        //     return;
        // }
        if(binaryString.length() == 0){
            return;
        }
        if(index == binaryString.length()){
            output = output + cur.data;
            return;
        }
        if(index < 0){
            return;
        }
        if(binaryString.charAt(index) == '0'){
            if(cur.left != null){
                // cur = cur.left;
                // recur(root, cur.left, binaryString, index++, output);
                index++;
                recur(root, cur.left, binaryString, index);
            }
            else{
                output = output + cur.data;
                cur = root;
                // index--;
                // recur(root, cur, binaryString, index++, output);   
                recur(root, cur, binaryString, index);   
            }
        }

        else{
            if(cur.right != null){
                // cur = cur.left;
                // recur(root, cur.right, binaryString, index++, output);
                index++;
                recur(root, cur.right, binaryString, index);
            }
            else{
                output = output + cur.data;
                cur = root;
                // index--;
                // recur(root, cur, binaryString, index++, output);   
                recur(root, cur, binaryString, index);   
            }
        }

        // for(int i=0; i<binaryString.length(); i++){
        //     char c = binaryString.charAt(i);
        //     if(c == '0'){
        //         if(cur.left != null){
        //             cur = cur.left;
        //         }
        //         else{
        //             output = output + cur.data;
        //             cur = root;
        //             i--;
        //         }
        //     }
        //     else{
        //         if(cur.right != null){
        //             cur = cur.right;
        //         }
        //         else{
        //             output = output + cur.data;
        //             cur = root;
        //             i--;
        //         }
        //     }
        // }
        // output = output + cur.data;
        // return output;
    }
}

//************************NON-Recurssive solution*******************************

/*

class Decode
{
    static String decodeHuffmanData(MinHeapNode root, String binaryString)
    {
        
        // add your code here
        MinHeapNode cur = root;
        String output = "";
        for(int i=0; i<binaryString.length(); i++){
            char c = binaryString.charAt(i);
            if(c == '0'){
                if(cur.left != null){
                    cur = cur.left;
                }
                else{
                    output = output + cur.data;
                    cur = root;
                    i--;
                }
            }
            else{
                if(cur.right != null){
                    cur = cur.right;
                }
                else{
                    output = output + cur.data;
                    cur = root;
                    i--;
                }
            }
        }
        output = output + cur.data;
        return output;
    }
}


*/
