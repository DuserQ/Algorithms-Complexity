/* Se realiza una prueba con n particulas ubicadas en el plano cartesiano para encontrar la distancia
minima de cada una dividiendo el espacio /2 para luego comparar cuales la distancia minima entre cada punto.
 * Algoritmo y complejidad
 * Santiago Hernandez Cadavid NCR: 200153162
 * Universidad del Norte
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class Times {

    private static void create() // creates a file.
    {
        try {
            // defines name of the file.
            String fname = ("Times.txt");

            File f = new File(fname);

            String msg = "creating file `" + fname + "' ... ";
            // creates the new file
            f.createNewFile();

        } catch (IOException err) {

            err.printStackTrace();
        }

    }
    // Se escriben los datos en un archivo de texto o .txt
    private static void write(int Time, ArrayList<Integer> is, ArrayList<Integer> Compars, ArrayList<Integer> Runt)
    {
        try {

            String filename = ("Times.txt");

            PrintWriter out = new PrintWriter(filename);
            String fmt = ("%10s %10s %10s\n");
            for (int i = 0; i < Time; ++i) {
                out.printf(fmt, is.get(i), Compars.get(i), Runt.get(i));
            }

            out.close();
        } catch (FileNotFoundException err) {

            err.printStackTrace();
        }

    }
    //Reach es el numero de enteros a llegar.
    public void Anali(int Reach) {
        ArrayList<Integer> Trun = new ArrayList<Integer>();
        ArrayList<Integer> I = new ArrayList<Integer>();
        //Se inicializa la lista.
        ArrayList<Integer> Comparar = new ArrayList<Integer>();
        for (int i = 1000; i < Reach; i = i * 4) {
            Recursive_Lab Desmos = new Recursive_Lab();
            System.out.println(i);
            long total = 0;
            int C;
            //Se almacenan las coordenadas X y Y.
            ArrayList<Pts> coor = Recursive_Lab.Empezar(i);
            coor.sort(Comparator.comparing(Point -> Point.X));
            for (int j = 0; j < 256; j++) {
                long startTime = System.nanoTime();
                Recursive_Lab.ClosestPair(i, coor, 999999999);
                long endTime = System.nanoTime();
                //Se calcula el tiempo por repeticiones.
                long totalTime = endTime - startTime;
                total = total + totalTime;
            }
            C = Desmos.getComparisons();
            //Se halla el promedio de iteraciones.
            C = C / 256;
            //Se halla el tiempo de ejecucion promedio
            total = total / 256;
            Trun.add((int) total);
            //Se almacenan en un arreglo el numero total de coordenadas
            I.add(i);
            Comparar.add(C);
        }
        create();
        write(I.size(), I, Comparar, Trun);
    }
}

//Se define una clase con las coordenadas X y Y.
class Pts {

    int X;
    int Y;
    int Posi;

    public Pts(int Xx, int Yy, int Pos) {
        this.X = Xx;
        this.Y = Yy;
        this.Posi = Pos;
    }
}

public class Recursive_Lab {

    //Se mantiene un seguimiento de cada repeticion.
    public static int Count;

    public  Recursive_Lab() {
        Count = 0;
    }

    public int getComparisons() {
        return Count;
    }

    public static double[] BruteForce(int N, List<Pts> Coords, double d_min) { // Se halla el par mas cercano con el algoritmo de fuerza bruta
        double dmin = d_min;
        //Se crea una matriz para almacenar el d_min y el punto con el par mas cercano.
        double[] A = new double[3];
        A[0] = dmin;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                //Se compara la distancia con cada par.
                double d = Distancia(Coords, i, j);
                if (d < dmin) {
                    Count++;
                    dmin = d;
                    A[0] = d;
                    A[1] = Coords.get(i).Posi;
                    A[2] = Coords.get(j).Posi;
                } else {
                    Count++;
                }
            }
        }
        return A;
    }
    // Se imprimen coordenadas.
    public static void PCoor(List<int[]> Coord) {
        for (int[] ints : Coord) {
            System.out.println("X: " + ints[0] + " Y: " + ints[1] + " Posicion: " + ints[2]);
        }
    }

    public static ArrayList<Pts> UCandidato(List<Pts> Coors, double min) {
        ArrayList<Pts> Candidato = new ArrayList<Pts>();
        int i = 0;
        //Se comparan las posiciones entre X y Y.
        while (i < Coors.size() / 2) {
            if (Math.abs(Coors.get(i).X - Coors.get(Coors.size() / 2).X) < min && Math.abs(Coors.get(i).Y - Coors.get(Coors.size() / 2).Y) < min) {
                Count++;
                //Se crea un candidato cuando la distancia es menor que d_min.
                Candidato.add(Coors.get(i));
                i++;
            } else {
                Count++;
                i = Coors.size() / 2;
            }
        }
        //Se comparan para no obtener repetidos.
        while (i < Coors.size()) {
            if (Math.abs(Coors.get(i).X - Coors.get(Coors.size() / 2 - 1).X) < min && Math.abs(Coors.get(i).Y - Coors.get(Coors.size() / 2 - 1).Y) < min) {
                Count++;
                Candidato.add(Coors.get(i));
                i++;
            } else {
                Count++;
                i = Coors.size();
            }
        }
        return Candidato;
    }
    // Se encuentra el par mas cercano usando recursividad
    public static double[] ClosestPair(int N, List<Pts> x, double Mdist) {
        //Si hay mas de 3 particulas, se divide el plano entre 2.
        if (N > 3) {
            double[] Ni1 = new double[3];
            double[] Ni2 = new double[3];
            int Ledge = 0;
            Count++;
            if (N % 2 == 1) {
                Ledge = 1;
            }

            Ni1 = ClosestPair(N / 2, x.subList(0, N / 2), Mdist);
            Ni2 = ClosestPair(N / 2 + Ledge, x.subList(N / 2, N), Mdist);
            double[] n = new double[3];
            if (Ni1[0] < Ni2[0]) {
                n = Ni1;
                Count++;
            } else {
                Count++;
                n = Ni2;
            }
            //Lista que almacena las posibles coordenadas.
            ArrayList<Pts> Candi = new ArrayList<Pts>();
            Candi = UCandidato(x, n[0]);
            //Se aplica el algoritmo de fuerza bruta.
            if (Candi.size() > 1) {
                Count++;
                Ni1 = BruteForce(Candi.size(), Candi, Mdist);
                if (Ni1[0] < n[0]) {
                    Count++;
                    return Ni1;
                } else {
                    Count++;
                    return n;
                }
            } else {
                Count++;
                return n;
            }
        } else {
            Count++;
            // Se aplica fuerza bruta para 3 o menos coordenadas.
            return BruteForce(N, x, Mdist);
        }
    }
    // Se calcula la distancia entre i y j
    public static double Distancia(List<Pts> Coordes, int i, int j) {
        int x1 = Coordes.get(i).X;
        int x2 = Coordes.get(j).X;
        int y1 = Coordes.get(i).Y;
        int y2 = Coordes.get(j).Y;
        double d = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
        return Math.sqrt(d);
    }

    //Se crean coordenadas aleatorias.
    public static ArrayList<Pts> Empezar(int Tamanio) {
        ArrayList<Pts> L = new ArrayList<Pts>();
        Random Ram = new Random();
        for (int i = 0; i < Tamanio; i++) {
            Pts P = new Pts(Ram.nextInt(1000), Ram.nextInt(1000), i);
            L.add(P);
        }

        return L;
    }

    public static void main(String[] args) {

        Times tca = new Times();
        tca.Anali(2000000);
    }
}