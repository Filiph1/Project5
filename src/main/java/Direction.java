public enum Direction {
    UP ('U'){
        @Override
        public int[] updateCoordinates(int[] coords , int spaces){
            int[] newCoords = new int[2];
            newCoords[0] = coords[0];
            newCoords[1] = coords[1] - spaces;

            return newCoords;
        }
    },
    DOWM ('D'){
        @Override
        public int[] updateCoordinates(int[] coords , int spaces){
            int[] newCoords = new int[2];
            newCoords[0] = coords[0];
            newCoords[1] = coords[1] + spaces;

            return newCoords;
        }
    },
    LEFT ('L'){
        @Override
        public int[] updateCoordinates(int[] coords , int spaces){
            int[] newCoords = new int[2];
            newCoords[0] = coords[0] - spaces;
            newCoords[1] = coords[1];

            return newCoords;
        }
    },
    RIGHT('R'){
        @Override
        public int[] updateCoordinates(int[] coords , int spaces){
            int[] newCoords = new int[2];
            newCoords[0] = coords[0]+ spaces;
            newCoords[1] = coords[1];

            return newCoords;
        }
    };


        private final char c;

    Direction(char c){

        this.c = c;
    }

    public abstract int[] updateCoordinates(int[] coords , int spaces);

    public static int[] getNewCoordinatesForDirection(char direction, int[] coords, int spaces)
    {

        for (Direction d: Direction.values()) {

            if (d.c == direction)
                return d.updateCoordinates(coords, spaces);
        }
        throw new IllegalArgumentException(direction + ": not a valid direction");

    }
}
