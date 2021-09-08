package java12to17.sealedclass;

/**
 * Sealed Interface
 */
public sealed interface ShapeService permits Square, Rectangle {
    default int getArea(int a, int b) {
        return a * b;
    }

    int getPerimeter();
}
