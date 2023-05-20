public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printme();
        stack.push(0);
        stack.printme();
        stack.push(1);
        stack.printme();
        stack.push(2);
        stack.printme();
        stack.push(3);
        stack.printme();
        stack.push(4);
        stack.printme();
        stack.push(5);
        stack = stack.reverse();
        stack.printme();
   /*     stack.printme();
        stack.reverse();
        System.out.println(stack.pop());
        stack.printme();
        System.out.println(stack.pop());
        stack.printme();
        System.out.println(stack.pop());
        stack.printme();
        System.out.println(stack.pop());
        stack.printme();
        System.out.println(stack.pop());
        stack.printme();
        System.out.println(stack.pop());
        stack.printme();
        */
    }

    public static class Stack {
        private Node head;
        private Node tail;

        public void push (int value) {
            if (head == null) {
                head = new Node(value, null);
                tail = head;
            } else {
                head = new Node(value, head);
            }
        }

        public int pop () {
            int value = 0;
            if (head == null) {
                System.out.println("Нет элементов!"); // TODO подумать, нихрена не работает.
            } else {
                value = head.value;
                head = head.prev;
            }
            return value;
        }

        public void printme() {
            if (head == null) {
                System.out.println("EMPTY");
            } else {
                Node node = head;
                while (node != null) {
                    System.out.print(node.value);
                    if (node.prev != null) {
                        System.out.print(" -> ");
                    }
                    node = node.prev;
                }
                System.out.println();
            }
        }
        public Stack reverse () {
            Stack reversed_stack = new Stack();
            if (head == null) {
                return reversed_stack;
            } else {
                Headtail headtail = reversed_head(this.head);
                reversed_stack.head = headtail.head;
                return reversed_stack;}

        }

        public Headtail reversed_head (Node node) {
            Node new_node = new Node(node.value, null);
            if (node.prev == null) {
                return new Headtail(new_node, new_node);
            } else {
                Headtail headtail = reversed_head(node.prev);
                tail.prev = new_node;
                return headtail;
            }
        }

        public static class Headtail {
            public Node head;
            public Node tail;

            public Headtail(Node head, Node tail) {
                this.head = head;
                this.tail = tail;
            }
        }
    }

    public static class Node {
        private final int value;
        private Node prev;

        public Node(int value, Node prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}