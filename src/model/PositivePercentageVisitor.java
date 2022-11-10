package model;
import java.util.List;

public class PositivePercentageVisitor extends Visitor {
	
	private int totalPositiveMessages;
	private List<String> positiveWords; 
	
	public PositivePercentageVisitor(List<String> positiveWords) {
		this.positiveWords = positiveWords;
	}
	
	public int getPositiveMessages() {
		return totalPositiveMessages;
	}

	@Override
	public void visitUser(User user) {
		getPositiveTweets(user.getTweets());
	}

	@Override
	public void visitGroup(UserGroup group) {}
	
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
