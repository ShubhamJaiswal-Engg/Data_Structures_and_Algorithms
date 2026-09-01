
// 119. Pascal's Triangle II

class KthPascal {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            result.add(1); // extend the row with a new trailing 1
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
        }
        return result;
    }
}

// opyimize
// Time complexity -> O(n)
// Space Complexity -> O(1)

class KthPascal {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> ans = new ArrayList<>();

        long value = 1;
        ans.add(1);
        // Combinatorial
        // c(n, k) = (c(n, k-1) * (n - k + 1)) / k
        for (int index = 1; index <= rowIndex; index++) {
            value = value * (rowIndex - index + 1) / index;
            ans.add((int) value);
        }

        return ans;
    }
}