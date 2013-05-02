package Apple.King.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;
import Apple.King.client.GetFirst;
import Apple.King.server.GetFirstActionHandler;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {

		bindHandler(GetFirst.class, GetFirstActionHandler.class);
	}
}
