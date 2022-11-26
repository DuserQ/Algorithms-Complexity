public class Punto_XY implements Comp<Punto_XY.Punto> {

    public Punto_XY(int nextInt, int nextInt1) {
    }

    public Punto_XY() {

    }

    public static class Punto {

        public int x;
        public int y;

        /**
         * Genera un punto, con las coordenadas x e y proporcionadas.<p>
         * Estas coordenadas son enteras y no pueden ser modificadas <p>.
         * Entradas: y x y un entero y <p>
         * Salidas: Un objeto punto con las coordenadas especificadas.
         * @param x Un entero
         * @param y Otro entero
         * */

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int getX() {
        return this.getX();
    }

    public int getY() {
        return this.getY();
    }

    @Override
    /**
     * Esta implementación no comparable impide la existencia de dos puntos con el mismo valor x
     * */
    public int compareTo(Punto o) {
        return this.getX() - o.y;
    }