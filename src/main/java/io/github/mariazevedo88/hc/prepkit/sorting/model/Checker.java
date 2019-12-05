package io.github.mariazevedo88.hc.prepkit.sorting.model;

import java.util.Comparator;

public class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
		if(a.getScore() == b.getScore()) {
			return a.getName().compareTo(b.getName());
		}
		return b.getScore() - a.getScore();
    }
}
