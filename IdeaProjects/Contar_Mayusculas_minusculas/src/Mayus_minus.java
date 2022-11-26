import java.util.Scanner;

public class Mayus_minus {
    public static void main(String[] args) {
        Scanner ingresar=new Scanner(System.in);
        System.out.println("ingresar texto");
        String texto= ingresar.nextLine();
        int numeromayor=0, numeromenor=0;

        for (int i=0; i < texto.length(); i++) {
            //CODIGO ASCII NUMERO A=65 HASTA NUMERO 90 = Z (MAYUSCULAS)
            if (texto.charAt(i)>=65 && texto.charAt(i)<=90) {
                numeromayor++;
            }else{
                if (texto.charAt(i)>=97 && texto.charAt(i)<=122){
                    numeromenor++;
                }
            }
        }
        System.out.println("el numero de mayusculas del texto es: "+numeromayor);
        System.out.println("el numero de minusculas del texto es: "+numeromenor);
    }
}
