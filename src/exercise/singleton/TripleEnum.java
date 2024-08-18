package exercise.singleton;

public enum TripleEnum {

    ALPHA, BETA, GAMMA;

    TripleEnum() {
        System.out.println("The instance " + this + " is created");
    }
    public static TripleEnum getInstance(String name) {
        return TripleEnum.valueOf(name);
    }
}
