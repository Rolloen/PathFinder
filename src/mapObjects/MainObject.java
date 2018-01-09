package mapObjects;

public class MainObject {

	// Variable

    private int x, y;
    private char shape;

	// private boolean visible;

	// Constructor
	public MainObject(int x ,int y, char shape) {
        this.x = x;
        this.y = y;
        this.shape = shape;
        // this.visible = false;
    }

    public MainObject(int x ,int y) {
        this.x = x;
        this.y = y;
        this.shape = '_';
        // this.visible = false;
    }
	// Accessories
	/*
	 * public boolean isVisible() { return visible; } public void setVisible(boolean
	 * Visible) { this.visible = Visible; }
	 */

    public void setShape(char shape) {
        this.shape = shape;
    }

    public char getShape() {
        return shape;
    }

    public String toString() {
	    return Character.toString(shape);
	}
	
}
