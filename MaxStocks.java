// New stock prices are coming every hour, 
// Design a data structure to store stock prices and getMaxStock() to get Max stock at price at that instance for last K hours. 
// K will be known since beginning. 
// Stock prices may not come every hour.  

// For example, given K = 4, a data stream of values comes every hour --> Hour 1: [10,5,7], Hour 2: [7,8], Hour 3: [], Hour 4: [3,9], Hour 5: [4,6]...... At hour 1-4 getMaxStock() should return 10 and at hour 5 it should return 9.

// The class has two methods: getMaxStock() and newStocks(data) where data is a list of new incoming stocks. So essentially each time newStocks is called, that means another hour has passed.


// https://leetcode.com/discuss/interview-question/421636/unicorn-onsite-glassdoor-question




import java.util.*;

class MaxStock{

	Queue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
	Queue<Integer> stocksQueue = new LinkedList<>();
	int k;

	MaxStock(int k){
		this.k = k;
	}
	int getMax(){
		return maxHeap.peek();
	}

	void add(int stocks[]){

		if(stocks == null || stocks.length == 0){
			maxHeap.offer(0);
			stocksQueue.offer(0);
			return;
		}

		int maxStockForHour = Integer.MIN_VALUE;
		for (int i=0; i<stocks.length; i++) {
			maxStockForHour = Math.max(maxStockForHour, stocks[i]);
		}

		maxHeap.offer(maxStockForHour);
		stocksQueue.offer(maxStockForHour);

		while(stocksQueue.size() > k){
			int removeElement = stocksQueue.poll();
			maxHeap.remove(removeElement);
		}
	}
}

public class MaxStocks{

	public static void main(String[] args) {
		int k = 4;
		MaxStock maxStock = new MaxStock(k);
		maxStock.add(new int[]{10,5,7});
		System.out.println(maxStock.getMax());
		maxStock.add(new int[]{7,8});
		System.out.println(maxStock.getMax());
		maxStock.add(new int[]{});
		System.out.println(maxStock.getMax());
		maxStock.add(new int[]{3,9});
		System.out.println(maxStock.getMax());
		maxStock.add(new int[]{4,6});
		System.out.println(maxStock.getMax());
	}
}
