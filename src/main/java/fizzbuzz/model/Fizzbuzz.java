package fizzbuzz.model;

/**
 *
 * @author itagaki
 * fizzbuzz問題に答える
 *
 */
public class Fizzbuzz {
	/**
	 *
	 * @param call 入力値
	 * @return fizzbuzzの答え
	 */
	public static String answer(String call){
		try {
			int callNumber = Integer.parseInt(call);
			return answer(callNumber);
		} catch(NumberFormatException e) {
			return call;
		}
	}

	/**
	 *
	 * @param callNumber 入力値
	 * @return fizzbuzzの答え
	 */
	public static String answer(int callNumber){
		if(callNumber%3==0 && callNumber%5==0)return "fizzbuzz";
		if(callNumber%3==0)return "fizz";
		if(callNumber%5==0)return "buzz";
		return String.valueOf(callNumber);
	}

}
