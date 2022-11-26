import java.util.ArrayList;
import java.util.Random;
public class Closest_Pair_Santiago_Hernandez_Cadavid {
    Punto_XY punto_xy;
    public static ArrayList Goite = new ArrayList<Punto_XY>();

      public Closest_Pair_Santiago_Hernandez_Cadavid() {
          Punto_XY punto_xy = new Punto_XY();
          punto_xy.getX();
      }
    public static void main(String[] args) {
        /**
         * La siguiente sección crea y almacena la cantidad deseada de puntos
         * en un arraylist cada punto con coordenadas x e y aleatorias que oscilan
         * entre 0 y 20
         */
        Random random = new Random();
        for (int i = 1; i <= 6; i++) {
            Goite.add(new Punto_XY(random.nextInt(21), random.nextInt(21)));
        }

        for (Object p : Goite) {
            Punto_XY a = (Punto_XY) p;
            System.out.println(a.getX() + ", " + a.getY());
        }
        bruteForce(Goite);
    }

    /**
     * El siguiente void itera a través de la ArrayList comparando cada punto
     con los demás y determina qué par tiene la Distancia mínima de todos
     e imprime el par y su Distancia en la consola
     *
     * @param lista Una ArrayList que contiene todos los puntos introducidos: El Array con
    todos los puntos de salida: El par más cercano y su Distancia
     */
    public static void bruteForce(ArrayList<Punto_XY> lista) {
        double Cercanos = Distancia(lista.get(0), lista.get(1));
        Punto_XY puntoA = lista.get(0);
        Punto_XY PuntoB = lista.get(1);

        for (Punto_XY lista1 : lista) {
            for (int i = lista.indexOf(lista1) + 1; i < lista.size(); i++) {
                if (Distancia(lista1, lista.get(i)) < Cercanos) {
                    Cercanos = Distancia(lista1, lista.get(i));
                    puntoA = lista1;
                    PuntoB = lista.get(i);
                }
            }
        }
        System.out.println("Los puntos mas cercanos son: (" + puntoA.getX() + ", " + puntoA.getY() + ") and (" + PuntoB.getX() + ", " + PuntoB.getY() + ")");
        System.out.println("Distancia: " + Cercanos);
    }

    /**
     * El siguiente método devuelve la Distancia entre dos objetos punto
     comparando sus x , y
     *
     *@param a El primer punto a comparar
     * @param b El segundo punto a comparar
     * @retorno La distancia entre estos puntos como entradas dobles: Punto a y
    punto b salidas: La Distancia entre los puntos
     */
    public static double Distancia(Punto_XY a, Punto_XY b) {
        double sqrt;
        sqrt = Math.sqrt(Math.pow((a.getY()- b.getY()), 2) + Math.pow((b.getX() - a.getX()), 2));
        return sqrt;

    }

}