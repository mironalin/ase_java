package eu.deic.fp.fi_lambda;

@FunctionalInterface
interface GreetingService {
    void sayMessage(String message);

}

@FunctionalInterface
interface MathOperation<T1, T2, T3> {
    T3 operation(T1 a, T2 b);
}

class MathOpClass<C1, C2, C3> {
    public C3 operate(C1 a, C2 b, MathOperation<C1, C2, C3> mathOperation) {
        return mathOperation.operation(a, b);
    }
}

public class ProgMainLambda {
    public static void main(String[] args) {
        MathOpClass<Integer, Float, Double> tester = new MathOpClass<>();

        MathOperation<Integer, Float, Double> addition = (Integer a, Float b) -> {
            Double r = Double.parseDouble("" + (a.floatValue() + b.floatValue()));
            return r;
        };

        // MathOperation<Integer, Float, Double> subtraction = (x, y) ->
        // Double.valueOf(x - y);

        System.out.println("10 + 5 = " + tester.operate(Integer.valueOf(10), Float.valueOf(5), addition));

        // System.out.println("10 - 5 = " + tester.operate(Integer.valueOf(10),
        // Float.valueOf(5), subtraction));

        System.out.println(
                "10 + 5 = " + tester.operate(Integer.valueOf(10), Float.valueOf(5), (x, y) -> Double.valueOf(x - y)));

        GreetingService objLambda1 = (String msg) -> {
            System.out.println("Bonjour " + msg + "!");
        };
        objLambda1.sayMessage("Jean-Yves");

        GreetingService objL2 = msg -> System.out.println("Hello " + msg + "!");
        objL2.sayMessage("Jake");

        objLambda1.sayMessage("Nicolas");
    }
}
