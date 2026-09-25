
// 22. Generate Parentheses

class GenerateParen22 {
    private void parGenerator(String str, int openCount, int closeCount,List<String> genParen, int n) {
        if(openCount == n && closeCount == n) {
            genParen.add(str); 
        } else {
            if(openCount > closeCount){
                parGenerator(str+")", openCount, closeCount + 1, genParen, n);
            } 
            if(openCount <= n) {
                parGenerator(str+"(", openCount + 1, closeCount, genParen, n);
            }
        }
    }


    public List<String> generateParenthesis(int n) {

        List<String> genParen = new ArrayList<>();
        parGenerator("", 0, 0, genParen, n);
        return genParen;
    }
}