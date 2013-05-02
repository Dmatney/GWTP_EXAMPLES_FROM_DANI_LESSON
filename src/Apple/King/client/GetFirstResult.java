package Apple.King.client;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class GetFirstResult implements Result {

	private String text;

	@SuppressWarnings("unused")
	private GetFirstResult() {
		// For serialization only
	}

	public GetFirstResult(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
