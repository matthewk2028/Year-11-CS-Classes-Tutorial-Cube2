public class Cube {
    private int side;

    public Cube() {
        this.side = 1;
    }

    public Cube(int side) {
        validSide(side);
        this.side = side;
    }

    private void validSide(int side) {
        if (side < 1) {
            throw new IllegalArgumentException("A cube's side length must be equal to or greater than 1!");
        }
    }

    public int calculateVolume() {
        return side * side * side;
    }

    public int calculateSurfaceArea() {
        return side * side * 6;
    }

    public int getSide() {
        return this.side;
    }

    public void setSide(int side) {
        validSide(side);
        this.side = side;
    }

    @Override
    public String toString() {
        return String.format("Cube{side=%d}", this.side);
    }
}