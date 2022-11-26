import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Prueba_1 {


            public static void main (String [] args)
            // reads and prints the GPL on the console one character at a time
            {
                //read ();

                System.out.print("hello");
            }

            /*
            // implementation:
            private static void read ()
            // opens GPL file for reading one character at a time
            {
                String filename = ("GPL.txt");
                File f = new File (filename);
                try
                // the compiler complains if not in a try - catch structure
                {
                    // we need a buffer reader to read char-by-char
                    FileReader fr = new FileReader (f);
                    BufferedReader br = new BufferedReader (fr);
                    // reads the buffer one character at a time
                    read (br);
                }
                catch (FileNotFoundException e)
                {
                    // prints the stack trace for troubleshooting
                    e.printStackTrace();
                }

            }


            private static void read (BufferedReader br)
            {
                // reads the first character in the file
                int c = readBuffer (br);
                while (c != 0xFFFFFFFF)	/* (Note: 0xFFFFFFFF = -1) */
                // reads one character at a time until end-of-file EOF
                {
                    // prints the read character on the console
                    System.out.printf("%c", c);
                    // reads the next character
                    c = readBuffer (br);
                }
            }


            private static int readBuffer (BufferedReader br)
            // tries to read a single character from buffer stream
            {
                int c = 0;
                // the compiler complains if not in a try - catch structure
                try { c = br.read(); }
                catch (IOException e) { e.printStackTrace(); }
                return c;
            }
        }
        */
    }

