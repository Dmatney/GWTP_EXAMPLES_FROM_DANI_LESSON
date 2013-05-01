package Apple.King.client;

import com.gwtplatform.mvp.client.proxy.Gatekeeper;

public class TestGatekeeper implements Gatekeeper{

	@Override
	public boolean canReveal() {
		return false;
	}

}
