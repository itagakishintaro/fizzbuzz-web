package fizzbuzz.model;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import cucumber.annotation.ja.*;

public class FizzbuzzAcceptanceTest {
	String call, answer;

	@もし("^\"([^\"]*)\"が３の倍数$")
	public void が３の倍数(String call) throws Throwable {
	    this.call = call;
	}

	@ならば("^answerはfizzであるべき$")
	public void answerはfizzであるべき() throws Throwable {
	    assertThat(Fizzbuzz.answer(call), is("fizz"));
	}

	@もし("^\"([^\"]*)\"が５の倍数$")
	public void が５の倍数(String call) throws Throwable {
		this.call = call;
	}

	@ならば("^answerはbuzzであるべき$")
	public void answerはbuzzであるべき() throws Throwable {
		assertThat(Fizzbuzz.answer(call), is("buzz"));
	}

	@もし("^\"([^\"]*)\"が３の倍数かつ５の倍数$")
	public void が３の倍数かつ５の倍数(String call) throws Throwable {
		this.call = call;
	}

	@ならば("^answerはfizzbuzzであるべき$")
	public void answerはfizzbuzzであるべき() throws Throwable {
		assertThat(Fizzbuzz.answer(call), is("fizzbuzz"));
	}

	@もし("^\"([^\"]*)\"が整数以外$")
	public void が整数以外(String call) throws Throwable {
		this.call = call;
	}

	@ならば("^answerは\"([^\"]*)\"であるべき$")
	public void answerは_であるべき(String arg1) throws Throwable {
		assertThat(Fizzbuzz.answer(call), is(call));
	}
}
