
// 887. Super Egg Drop

class SuperEggDrop887 {
    public int superEggDrop(int eggs, int floors) {
        int[][] minMoves = new int[floors + 1][eggs + 1];

        for (int eggCount = 1; eggCount <= eggs; eggCount++) {
            // floor 0 (ground)
            minMoves[0][eggCount] = 0;
            // floor 1
            minMoves[1][eggCount] = 1;
        }

        for (int floorCount = 1; floorCount <= floors; floorCount++) {
            // having egg Zero
            minMoves[floorCount][0] = Integer.MAX_VALUE;
            // having egg 1
            minMoves[floorCount][1] = floorCount;
        }

        for (int floorCount = 2; floorCount <= floors; floorCount++) {
            for (int eggCount = 2; eggCount <= eggs; eggCount++) {
                int lowFloor = 1, highFloor = floorCount;
                int movesNeeded = 0, bestMoves = Integer.MAX_VALUE;

                while (lowFloor <= highFloor) {
                    int dropFloor = (lowFloor + highFloor) / 2;

                    // egg breaks -> search below, with one egg fewer
                    int breakCase = minMoves[dropFloor - 1][eggCount - 1];
                    // egg survives -> search above, same eggs
                    int surviveCase = minMoves[floorCount - dropFloor][eggCount];

                    // +1 for floor increase
                    movesNeeded = 1 + Math.max(breakCase, surviveCase);

                    if (breakCase < surviveCase) {
                        lowFloor = dropFloor + 1;
                    } else {
                        highFloor = dropFloor - 1;
                    }
                    bestMoves = Math.min(bestMoves, movesNeeded);
                }
                minMoves[floorCount][eggCount] = bestMoves;
            }
        }
        return minMoves[floors][eggs];
    }
}

class SuperEggDrop887 {
    public int superEggDrop(int eggs, int floors) {
        int[] covered = new int[eggs + 1];   // covered[e] = f(moves, e)
        int moves = 0;

        while (covered[eggs] < floors) {
            moves++;
            // go from high e to low e so covered[e - 1] is still the previous move's value
            for (int e = eggs; e >= 1; e--) {
                covered[e] = covered[e] + covered[e - 1] + 1;
            }
        }
        return moves;
    }
}