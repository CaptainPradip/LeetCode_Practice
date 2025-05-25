class BrowserHistory {
    private Stack<String> history;
    private Stack<String> future;
    private String currentUrl;

    public BrowserHistory(String homepage) {
        this.history = new Stack<>();
        this.future = new Stack<>();
        this.currentUrl = homepage;
    }

    public void visit(String url) {
        // as we are visiting newly site
        this.history.push(currentUrl);
        this.currentUrl = url;
        this.future = new Stack<String>(); // as we are entering the url so future should be clear

    }

    public String back(int steps) {
        while (steps > 0 && !history.isEmpty()) {
            future.push(currentUrl); // first put the url in future ;
            currentUrl = history.pop(); // navigate to the history url
            steps--;
        }
        return currentUrl;
    }

    public String forward(int steps) {
        while (steps > 0 && !future.isEmpty()) {
            history.push(currentUrl); // first put the current url in history;
            currentUrl = future.pop(); // navigate to the future url
            steps--;
        }
        return currentUrl;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */