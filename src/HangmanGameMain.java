public class HangmanGameMain {

    public static void main(String[] args) {

        HLogic myHang = new HLogic();

        while(!myHang.isGameOver()){

            myHang.playTheGame();

        }
    }




}
