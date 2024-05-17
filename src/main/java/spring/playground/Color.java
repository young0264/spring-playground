package spring.playground;

public enum Color {
    RED("red"),
    GREEN("green"),
    BLUE("blue");

    private final String key;

    // Constructor
    Color(String key) {
        this.key = key;
    }

    // Getter
    public String getKey() {
        return key;
    }

    // Static method to get enum value from key
    public static Color fromKey(String key) {
        for (Color color : Color.values()) {
            if (color.getKey().equalsIgnoreCase(key)) {
                return color;
            }
        }
        throw new IllegalArgumentException("No enum constant with key " + key);
    }
}
