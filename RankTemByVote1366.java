
// 1366. Rank Teams by Votes

class RankTemByVote1366 {
    public String rankTeams(String[] votes) {

        if(votes.length == 1) {
            return votes[0];
        }

        int teamLen = votes[0].length();
        int teams[][] = new int[26][teamLen];

        // team votes
        for(String vote : votes) {
            for(int p = 0; p < teamLen; p++) {
                teams[vote.charAt(p) - 'A'][p]++;
            }
        }

        // Only voted team can participate
        List<Character> votedTeam = new ArrayList<>();
        for(int i = 0; i < teamLen; i++) {
            votedTeam.add(votes[0].charAt(i));
        }


        // Sort them according to thir votes

        Collections.sort(votedTeam, (a, b) -> {
            for(int p = 0; p < teamLen; p++) {
                int ca = teams[a - 'A'][p];
                int cb = teams[b - 'A'][p];
                if(ca != cb) {
                    return cb - ca;
                }
            }
            return a - b; // Alphabetic Accending
        });

        StringBuilder sb = new StringBuilder();
        for(char c : votedTeam) {
            sb.append(c);
        }

        return sb.toString();
    }
}