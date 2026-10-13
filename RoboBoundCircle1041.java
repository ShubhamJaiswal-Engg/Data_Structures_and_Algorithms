
// 1041. Robot Bounded In Circle

class RoboBoundCircle1041 {
    public boolean isRobotBounded(String instructions) {
                 //N  E  S   W
       int dx[] = {0, 1, 0, -1};
       int dy[] = {1, 0, -1, 0};
       
       int dir = 0; // North
       // 0 North 
       // 1 East
       // 2 South
       // 3 West
       int x = 0 , y = 0;
       for( char ch : instructions.toCharArray()) {
        if(ch == 'G') {
            x += dx[dir];
            y += dy[dir];
            
        } else if(ch == 'L') {
            // 4 Direction circle 
            dir = (dir + 3) % 4; // turn left
        } else if(ch == 'R') {
            dir = (dir + 1) % 4;  // turn right
        }
       } 
       return (x == 0 && y == 0) || dir != 0;
    }
}