/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

//backtracking!!!
class Solution {
    //up right down left
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void cleanRoom(Robot robot) {
        backtracking(robot, 0, 0, 0, new HashSet<>());
    }
    
    public void backtracking(Robot robot, int x, int y, int curDir, HashSet<String> visited){
        robot.clean();
        visited.add(x + "-" + y);
        for (int i = 0; i < 4; i++) {
            int nextDir = (curDir + i) % 4;
            int newX = x + dirs[nextDir][0];
            int newY = y + dirs[nextDir][1];
            if (!visited.contains(newX + "-" + newY) && robot.move()) {
                backtracking(robot, newX, newY, nextDir, visited);
            }
            robot.turnRight();
        }
        
        //turn 180 and move 1 place which is origin cell but the direction is opposite
        robot.turnRight();
        robot.turnRight();
        robot.move();
        //turn 180 so that the direction is the same with before
        robot.turnRight();
        robot.turnRight();
        
    }
}
