import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HLogic {

    private String theWord;                                              // the word that has to be guessed
    private Set<String> guessedLetters = new HashSet<>();                // set of letters that player has guessed
    private int mistakeCount = 0;                                        // counter of how many mistakes has player made
    private ArrayList<String> listOfWords = new ArrayList<>();           // a list of words, from there one word is randomly chosen to be guessed

    private Scanner scan = new Scanner(System.in);


    // constructor populates the ArrayList with words, selects one random word to be the word to be guessed
    public HLogic() {

        listOfWords.add("cucumber");
        listOfWords.add("australia");
        listOfWords.add("rainwater");
        listOfWords.add("labrador");
        listOfWords.add("dumbledore");
        listOfWords.add("greenhouse");
        listOfWords.add("watermelon");
        listOfWords.add("schwarzenegger");
        listOfWords.add("fabulous");
        listOfWords.add("radioactive");
        listOfWords.add("bloodborne");
        listOfWords.add("venezuela");
        listOfWords.add("hippopotamus");
        listOfWords.add("abbreviation");
        listOfWords.add("trigonometry");
        listOfWords.add("eternal");

        this.theWord = wordSelect().toUpperCase();

    }

    // selects one random word from field listOfWords and returns it
    private String wordSelect(){

        int randomInt = (int) (Math.random() * listOfWords.size());

        return listOfWords.get(randomInt);

    }

    // the one of two public methods that are needed to play the game (other one is gameOver())
    public void playTheGame(){
        HGraphics.printAllGuessedLetters(guessedLetters);
        HGraphics.printHangman(mistakeCount);
        HGraphics.printLettersOfTheWord(guessedLetters, theWord);
        HGraphics.printGuessALetter();

        tryLetter();
    }

    // method for guessing if a letter is in The Word, return true if such a letter is in The Word (but only if its the first
    // time you guessed that letter, you can´t guess the same letter twice) return false in every other scenario
    private void tryLetter(){

        String inputWord = scan.nextLine();
        String inputLetter = convertInputToSingleLetter(inputWord);


        if(inputLetter.isEmpty()){
            return;
        }

        if(guessedLetters.contains(inputLetter)){
            System.out.println("You already guessed " + inputLetter + " letter, try something new.");
            System.out.println("******************************************************************");
            return;
        } else{
            guessedLetters.add(inputLetter);
        }


        if(theWord.indexOf(inputLetter) < 0){
            mistakeCount++;
            System.out.println("Sorry, there ain´t a letter like that in The Word. Mistakes: " + mistakeCount);


        } else if(theWord.indexOf(inputLetter) >= 0){

            System.out.println("Yay, there is a letter like that in The Word!");
            System.out.println("******************************************************************");

            return;
        }

        System.out.println("******************************************************************");
    }

    // converts players input (that can be longer than a single letter) to a single letter that is used afterwards
    private String convertInputToSingleLetter(String inputWord){

        String inputLetter;

        if(inputWord.length() > 1){
            inputLetter = inputWord.substring(0,1);
            if(isANumber(inputLetter)){
                System.out.println("******************************************************************");
                return "";
            }
            System.out.println("(We only take in the first letter, so it´s pretty pointless to type more)\n");
        } else {
            inputLetter = inputWord;
            if (isANumber(inputLetter)) {
                System.out.println("******************************************************************");
                return "";
            }
        }

        if((inputLetter.isEmpty()) || (inputLetter.equals(" "))){
            System.out.println("... you gotta type some letter in, dude");
            System.out.println("******************************************************************");
            return "";
        }

        return inputLetter.toUpperCase();

    }

    // checks whether the "letter" given by the player is actually a number
    private boolean isANumber(String inputWord){

        try{
            Double.parseDouble(inputWord);
            System.out.println("Hey, you gotta put letters in, not numbers.");
            return true;
        } catch (Exception e){
            return false;
        }

    }


    // returns true if the whole word has been correctly guessed, false otherwise
    private boolean isTheWordGuessed(){

        Set<Character> hashedWord = new HashSet<>();

        for(int i = 0; i < theWord.length(); i++){
            hashedWord.add(theWord.charAt(i));
        }

        int rightlyGuessedLetters = 0;

        for(String s : guessedLetters){
            if(theWord.contains(s)){
                rightlyGuessedLetters++;
            }
        }

        if(hashedWord.size() == rightlyGuessedLetters){
            return true;
        }

        return false;
    }

    // returns true if the game is over
    public boolean isGameOver(){

        if(mistakeCount == 7){

            System.out.println("Game Over: You Lost");
            System.out.println(theWord);
            System.out.println();
            return true;
        } else if(isTheWordGuessed()){

            System.out.println("Game Over: You Won!");
            System.out.println(theWord);
            System.out.println();
            return true;
        }

        return false;
    }


}
