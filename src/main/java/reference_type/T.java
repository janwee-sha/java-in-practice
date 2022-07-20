package reference_type;

public class T {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("object of type %s finalized.\n", this.getClass().getSimpleName());
    }
}
