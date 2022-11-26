public class Andrea_XD_ANDANTE {
        public static void main(String[] args) {
            for(float x=0; x < 13 ; x++ ){
                System.out.println(funcionRecursiva(x));
            }
        }

        public static float funcionRecursiva(float n){

      if (n == 0) {
                return 1;
            }
        if (n == 1) {
            return 2;
        }
                    return (7*funcionRecursiva(n-1) - (2*funcionRecursiva(n-2)))/3;

        }
}
