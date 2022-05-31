package Test;

public interface Beta extends Alpha{
    default String getString() {
        return "beta";
    }

}
