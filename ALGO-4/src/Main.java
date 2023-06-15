public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printMe();
        System.out.println("Добавим 0");
        stack.push(0);
        stack.printMe();
        System.out.println("Добавим 1");
        stack.push(1);
        stack.printMe();
        System.out.println("Добавим 2");
        stack.push(2);
        stack.printMe();
        System.out.println("Добавим 3");
        stack.push(3);
        stack.printMe();
        System.out.println("Добавим 4");
        stack.push(4);
        stack.printMe();
        System.out.println("Добавим 5");
        stack.push(5);
        stack.printMe();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printMe();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printMe();
        System.out.println("Ревёрс!");
        stack.reverse(stack);
        stack.printMe();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printMe();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printMe();
        System.out.println("Ревёрс!");
        stack.reverse(stack);
        stack.printMe();
        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printMe();        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printMe();
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

        public void printMe() {
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
        // Долго мучился, так и не получил желаемого результата, сделал так как представлено ниже, используя вспомогательный метод вставки в конец,
        // не смог разобаться с вариантом представленным в задании, в описании вспомогательный метод  reversed_head(node): принимает стек, а в псевдокоде
        // он принимает node, в общем не понятно, если можно пришлите в личку или еще куда-нибудь ссылку или скриншот на правильный вариант реализации
        // я очень хочу посмотреть правильный ответ. Или подскажите... Спасибо, хорошего времени суток.)
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