public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printme();
        System.out.println("Добавим 0");
        stack.push(0);
        stack.printme();
        System.out.println("Добавим 1");
        stack.push(1);
        stack.printme();
        System.out.println("Добавим 2");
        stack.push(2);
        stack.printme();
        System.out.println("Добавим 3");
        stack.push(3);
        stack.printme();
        System.out.println("Добавим 4");
        stack.push(4);
        stack.printme();
        System.out.println("Добавим 5");
        stack.push(5);
        stack.printme();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();
        System.out.println("Ревёрс!");
        stack.reverse(stack);
        stack.printme();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();
        System.out.println("Ревёрс!");
        stack.reverse(stack);
        stack.printme();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();
    }

    public static class Stack {
        private Node head;


        public void push (int value) {
            if (head == null) {
                head = new Node(value, null);
            } else {
                head = new Node(value, head);
            }
        }

        public Integer pop () {
            int value;
            if (head == null) {
                return null;
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
        private void reverse (Stack stack) {
            if (stack.head == null) {
                return;
            }
            int top = stack.pop();
            reverse(stack);
            insertBottom(stack,top);
        }
        private void insertBottom(Stack stack, int value) {
            if (stack.head == null) {
                stack.push(value);
            } else {
                int top = stack.pop();
                insertBottom(stack, value);
                stack.push(top);
            }
        }
    }

    public static class Node {
        private final int value;
        private final Node prev;

        public Node(int value, Node prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}