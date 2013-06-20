package fizzbuzz.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class FizzbuzzTest {

	@RunWith(Theories.class)
	public static class callが3の倍数の場合{
		@DataPoints
		public static String[] call = {"3", "３", "6"};

		@Theory
		public void 答えはfizz(String call) throws Exception {
			assertThat(Fizzbuzz.answer(call), is("fizz"));
		}
	}

	@RunWith(Theories.class)
	public static class callが5の倍数の場合{
		@DataPoints
		public static String[] call = {"5", "５", "10"};

		@Theory
		public void 答えはbuzz(String call) throws Exception {
			assertThat(Fizzbuzz.answer(call), is("buzz"));
		}
	}

	@RunWith(Theories.class)
	public static class callが3の倍数かつ5の倍数の場合{
		@DataPoints
		public static String[] call = {"15", "１５", "30"};

		@Theory
		public void 答えはfizzbuzz(String call) throws Exception {
			assertThat(Fizzbuzz.answer(call), is("fizzbuzz"));
		}
	}

	@RunWith(Theories.class)
	public static class callが3の倍数でも5の倍数でもない場合{
		@DataPoints
		public static String[] call = {"a", "1", "あ"};

		@Theory
		public void 答えはcallと同じ(String call) throws Exception {
			assertThat(Fizzbuzz.answer(call), is(call));
		}
	}
}
