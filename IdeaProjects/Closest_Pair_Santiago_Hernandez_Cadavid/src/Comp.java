public interface Comp<T> {
    /**
     * Esta implementación no comparable impide la existencia de dos puntos con el mismo valor x
     * */
    int compareTo(Punto_XY.Punto o);
}
