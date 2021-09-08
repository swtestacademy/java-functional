package java12to17.sealedclass;

//public final class Triangle extends Shape implements ShapeService {} -> Triangle is not allowed in the sealed hierarchy!!!
public final class Triangle {
    private final int base;
    private final int edge1;
    private final int edge2;
    private final int height;

    public Triangle(int base, int edge1, int edge2, int height) {
        this.base = base;
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.height = height;
    }

    public int getPerimeter() {
        return base + edge1 + edge2;
    }

    public int getArea() {
        return (base * height) / 2;
    }
}
