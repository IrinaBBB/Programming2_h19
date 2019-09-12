package generic_stack;

public class GenericStackDemo {
    public static void main(String[] args) {
        GenericStack<String> gsString = new GenericStack<>();
            gsString.push("one");
            gsString.push("two");
            gsString.push("three");

        while (!(gsString.isEmpty())) {
            System.out.println(gsString.pop());
        }

        GenericStack<Integer> gsInteger = new GenericStack<>();
            gsInteger.push(1);
            gsInteger.push(2);
            gsInteger.push(3);
            // gsInteger.push("4");
        while (!(gsInteger.isEmpty())) {
            System.out.println(gsInteger.pop());
        }
    }
}

