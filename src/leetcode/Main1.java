package leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        String line = in.nextLine();
        Integer[] m = Arrays.stream(line.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        line = in.nextLine();
        Integer[] n = Arrays.stream(line.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        int cost = in.nextInt();
        Node[] nodes = new Node[m.length];
        for (int i = 0; i < m.length; i++) {
            nodes[i] = new Node(m[i], n[i]);
        }

        nodes = Arrays.stream(nodes).sorted(Comparator.comparing(Node::getBuyPrice)).toArray(Node[]::new);
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getBuyPrice() > cost) {
                break;
            }
            if(nodes[i].getBenifit()<=0){
                continue;
            }
            cost += nodes[i].getBenifit();
        }

        System.out.println(cost);

    }

    static class Node {
        private int buyPrice;
        private int sellPrice;

        public Node(int buyPrice, int sellPrice) {
            this.buyPrice = buyPrice;
            this.sellPrice = sellPrice;
        }

        public int getBuyPrice() {
            return buyPrice;
        }

        public int getSellPrice() {
            return sellPrice;
        }

        public int getBenifit() {
            return sellPrice - buyPrice;
        }
    }
}


