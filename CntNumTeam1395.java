
// 1395. Count Number of Teams

class CntNumTeam1395 {
    public int numTeams(int[] rating) {
        int count = 0;
        for(int i = 0; i < rating.length; i++) { // i = middle soldier
            int leftSmaller = 0;
            int rightSmaller = 0;
            int leftGreater = 0;
            int rightGreater = 0;
            for(int j = 0; j < rating.length; j++) {
                if(j < i) { // j is in left side
                    if(rating[j] < rating[i]) leftSmaller++;
                    else if(rating[j] > rating[i]) leftGreater++; 
                } else if (j > i) { // j is in right side
                    if(rating[i] > rating[j]) rightSmaller++;
                    else if(rating[i] < rating[j]) rightGreater++;
                }
            }        // Increasing                // Decreasing
            count += leftSmaller * rightGreater + rightSmaller * leftGreater;
            // multiply because we want to combine two choice
        }
        return count;
    }
}