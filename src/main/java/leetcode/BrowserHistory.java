package leetcode;

import java.util.Stack;

/**
 * @author dylan.ll
 * @date 2020/6/14 19:55
 */
class BrowserHistory {

    Stack<String> visitHistory = new Stack<String>();
    int front = -1;

    public BrowserHistory(String homepage) {
        front=0;
        visitHistory.push(homepage);
    }

    public void visit(String url) {

        visitHistory.push(url);
        front=visitHistory.size()-1;
    }

    public String back(int steps) {
        front=front>steps ? front-steps:0;
        return visitHistory.get(front);
    }

    public String forward(int steps) {
        front=front+steps>visitHistory.size()-1 ? visitHistory.size()-1:front+steps;
        return visitHistory.get(front);
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leet");
        browserHistory.visit("google");
        browserHistory.visit("face");
        browserHistory.visit("you");
        //System.out.println(browserHistory.visitHistory.get(0));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));

        System.out.println(browserHistory.back(7));

    }
}

