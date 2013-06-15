package fizzbuzz.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FizzbuzzTest {
	@Test
	public void answerに3をコールすると答えはfizz() {
		assertThat(Fizzbuzz.answer("3"), is("fizz"));
	}

	@Test
	public void answerに5をコールすると答えはbuzz() {
		assertThat(Fizzbuzz.answer("5"), is("buzz"));
	}

	@Test
	public void answerに15をコールすると答えはfizzbuzz() {
		assertThat(Fizzbuzz.answer("15"), is("fizzbuzz"));
	}

	@Test
	public void answerに1をコールすると答えは1() {
		assertThat(Fizzbuzz.answer("1"), is("1"));
	}

	@Test
	public void answerにaをコールすると答えはa() {
		assertThat(Fizzbuzz.answer("a"), is("a"));
	}

}
