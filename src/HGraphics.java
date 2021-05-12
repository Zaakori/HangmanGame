import java.util.ArrayList;
import java.util.Set;

public class HGraphics {

   // prints out message "Guess a letter:"
   public static void printGuessALetter(){
       System.out.println("Guess a letter: ");
   }


    // prints out the hangman, depending on how many mistakes have been made there are more or less details
    public static void printHangman(int mistakesCount){

        if(mistakesCount == 0){
            System.out.println();
            return;
        } else if(mistakesCount == 1){

            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("  ");
            System.out.println("_____");

        } else if(mistakesCount == 2){

            System.out.println("  I");
            System.out.println("  I");
            System.out.println("  I");
            System.out.println("  I");
            System.out.println("__I__");

        } else if(mistakesCount == 3){

            System.out.println("  _______");
            System.out.println("  I     I");
            System.out.println("  I");
            System.out.println("  I");
            System.out.println("  I");
            System.out.println("__I__");

        } else if(mistakesCount == 4){

            System.out.println("  _______");
            System.out.println("  I     I");
            System.out.println("  I     0");
            System.out.println("  I");
            System.out.println("  I");
            System.out.println("__I__");

        } else if(mistakesCount == 5){

            System.out.println("  _______");
            System.out.println("  I     I");
            System.out.println("  I     0");
            System.out.println("  I     I");
            System.out.println("  I ");
            System.out.println("__I__");

        } else if(mistakesCount == 6){

            System.out.println("  _______");
            System.out.println("  I     I");
            System.out.println("  I     0");
            System.out.println("  I    -I-");
            System.out.println("  I ");
            System.out.println("__I__");

        } else if(mistakesCount == 7){

            System.out.println("  _______");
            System.out.println("  I     I");
            System.out.println("  I     0");
            System.out.println("  I    -I-");
            System.out.println("  I     ||");
            System.out.println("__I__");

        }
        System.out.println();

    }

    // prints out the empty and rightly guessed letters to the user
    public static void printLettersOfTheWord(Set<String> guessedLetters, String theWord){

       ArrayList<String> guessingTheWord = new ArrayList<>();

       boolean foundALetter = false;

       for(int i = 0; i < theWord.length(); i++){

           for(String s : guessedLetters){

               if(theWord.substring(i, i + 1).equals(s)){

                   guessingTheWord.add(s);
                   foundALetter = true;

               }

           }

           if(!foundALetter){
               guessingTheWord.add("_");
           }

           foundALetter = false;

       }

      for(String s : guessingTheWord){
          System.out.print(s + " ");
      }

        System.out.println();

    }


    // prints out all the letters that have been guessed so far
    public static void printAllGuessedLetters(Set<String> guessedLetters){

        System.out.print("Guessed letters: ");

       for(String s : guessedLetters){
           System.out.print(s + " ");
       }

        System.out.println();
        System.out.println();

    }

}
