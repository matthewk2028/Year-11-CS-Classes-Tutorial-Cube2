public class Cube2 {
    private Cube basicCube;
    private String color;

    public Cube2() {
        basicCube = new Cube();
        this.color = "black";
    }

    public Cube2(int side) {
        this();
        basicCube.setSide(side);
    }

    public Cube2(int side, String color) {
        this();
        basicCube.setSide(side);
        this.color = color;
    }

    public int getSide() {
        return basicCube.getSide();
    }

    public void setSide(int side) {
        basicCube.setSide(side);
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //the following methods have been started for you, but need to be completed
    public int calculateVolume() { return basicCube.calculateVolume();}
    public int calculateSurfaceArea() { return basicCube.calculateSurfaceArea();}

    public Cube2 add(Cube2 otherCube) {
        int total = this.calculateSurfaceArea() + otherCube.calculateSurfaceArea();
        int side = (int) Math.sqrt(total / 6);
        if (pythag(this.getSide(), otherCube.getSide(), side)) {return new Cube2(side);}
        throw new IllegalArgumentException("Three cube's side lengths must form a pythag triple");
    }

    public static boolean pythag(int side1, int side2, int side3) {
        if (side1 <= side3 && side2 <= side3) {return side1 * side1 + side2 * side2 == side3 * side3;}
        if (side1 <= side2 && side3 <= side2) {return side1 * side1 + side3 * side3 == side2 * side2;}
        if (side2 <= side1 && side3 <= side1) {return side2 * side2 + side3 * side3 == side1 * side1;}
        return false;
    }

    public Cube2 minus(Cube2 otherCube) {
        int diff = Math.abs(this.calculateSurfaceArea() - otherCube.calculateSurfaceArea());
        int side = (int) Math.sqrt(diff / 6);
        if (pythag(this.getSide(), otherCube.getSide(), side)) {return new Cube2(side);}
        throw new IllegalArgumentException("Three cube's side lengths must form a pyfag triple");
    }

    public boolean equals(Cube2 otherCube) {
        return this.getSide() == otherCube.getSide() && this.color.equals(otherCube.color);
    }

    @Override
    public String toString() {
        return String.format("Cube{side=%d, color=\"%s\"}", this.getSide(), this.color);
    }
}