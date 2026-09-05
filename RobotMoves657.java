
// 657. Robot Return to Origin

class RobotMoves657 {
    public boolean judgeCircle(String moves) {
        int robotMovesX = 0;
        int robotMovesY = 0;
        for(int i = 0; i < moves.length(); i++) {

            if(moves.charAt(i) == 'U') {
                robotMovesX -= 1;
            } else if(moves.charAt(i) == 'D') {

                robotMovesX += 1;
            } else if(moves.charAt(i) == 'L') {

                robotMovesY -= 1;
            } else {
                
                robotMovesY += 1;
            };   
        }
      return robotMovesX == 0 && robotMovesY == 0;
    }
}