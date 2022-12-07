package model.visitor.pattern;
import java.util.List;

import model.composite.pattern.UserGroupComposite;
import model.composite.pattern.UserLeaf;

public class PositivePercentageVisitor extends NodeVisitor {
	
	private int totalPositiveMessages;
	private List<String> positiveWords; 
	
	public PositivePercentageVisitor(List<String> positiveWords) {
		this.positiveWords = positiveWords;
	}
	
	public int getPositiveMessages() {
		return totalPositiveMessages;
	}

	@Override
	public void visitUser(UserLeaf userLeaf) {
		getPositiveTweets(userLeaf.getTweets());
	}

	@Override
	public void visitGroup(UserGroupComposite group) {}
	
	private void getPositiveTweets(List<String> tweets) {
		for (String tweet : tweets) {
			if (containsPositiveWord(tweet)) {
				totalPositiveMessages++;
			}
		}
	}
	
	private boolean containsPositiveWord(String tweet) {
		for (String word : tweet.toLowerCase().split(" ")) {
			if (positiveWords.contains(word)) {
				return true;
			}
		}
		return false;
	}
}
