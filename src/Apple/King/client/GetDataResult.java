package Apple.King.client;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class GetDataResult implements Result {

	private String data;

	@SuppressWarnings("unused")
	private GetDataResult() {
		// For serialization only
	}

	public GetDataResult(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}
}
