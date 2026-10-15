
// 2125. Number of Laser Beams in a Bank

class NumLasBank2125 {
    public int numberOfBeams(String[] bank) {
        List<Integer> beams = new ArrayList<>();

        for(String row : bank) {
            int laser = (int) row.chars().filter(ch -> ch == '1').count();
            if(laser !=  0) {
                beams.add(laser);
            }
        }
        if(beams.size() <= 1) {
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < beams.size() - 1; i++) {
            ans += beams.get(i) * beams.get(i+1);
        }
        return ans;
    }
}

// Second Approach S.C -> O(1)

class NumLasBank2125
{
    public int numberOfBeams(String[] bank)
    {
        int c = 0;
        int prev = 0;
        int ans = 0;

        for(String str : bank)
        {
            c = 0;

            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i) == '1')
                {
                    c++;
                }
            }

            if(c > 0)
            {
                ans += prev * c;
                prev = c;
            }
        }

        return ans;
    }
}